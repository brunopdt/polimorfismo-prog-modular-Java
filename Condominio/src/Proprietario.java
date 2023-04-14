
public class Proprietario extends EntidadeImobiliaria {

  public Proprietario(String nome, String cpf) {
    super(nome, cpf);
  }

  public double valorTotalArrecadado() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      valor += imovel.getValorAluguel();
    }

    return valor;
  }

  public double valorLiquidoAReceber() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      valor += imovel.getValorAluguel() - imovel.valorAluguelImobiliaria();
      if (imovel instanceof Casa) {
        valor -= ((Casa) imovel).getValorSeguroIncendio() / 12;
      } else if (imovel instanceof Apartamento) {
        valor -= ((Apartamento) imovel).getValorCondominio();
      }
    }

    return valor;
  }

}
