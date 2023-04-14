
public class Proprietario extends EntidadeImobiliaria {

  public Proprietario(String nome, String cpf) {
    super(nome, cpf);
  }

  /**
   * Método que calcula o valor total arrecadado pelo proprietário, somando o
   * valor bruto dos aluguéis mensais de todas as suas propriedades
   * 
   * @return double
   */
  public double valorTotalArrecadado() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      valor += imovel.getValorAluguel();
    }

    return valor;
  }

  /**
   * Método que calcula o valor líquido a ser recebido pelo proprietário,
   * subtraindo do aluguel bruto a comissão da imobiliária e as taxas de
   * condomínio ou seguro de
   * incêndio
   * 
   * @return double
   */
  public double valorLiquidoAReceber() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      valor += imovel.getValorAluguel() - imovel.comissaoImobiliaria();
      if (imovel instanceof Casa) {
        valor -= ((Casa) imovel).getValorSeguroIncendio() / 12;
      } else if (imovel instanceof Apartamento) {
        valor -= ((Apartamento) imovel).getValorCondominio();
      }
    }

    return valor;
  }

}
