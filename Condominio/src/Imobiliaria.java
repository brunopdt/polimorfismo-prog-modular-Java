
public class Imobiliaria extends EntidadeImobiliaria {

  public Imobiliaria(String nome, String cnpj) {
    super(nome, cnpj);
  }

  public double valorTotalArrecadado() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      valor += imovel.valorAluguelImobiliaria();
    }

    return valor;
  }
}
