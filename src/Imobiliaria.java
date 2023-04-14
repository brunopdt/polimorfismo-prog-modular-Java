
public class Imobiliaria extends EntidadeImobiliaria {

  public Imobiliaria(String nome, String cnpj) {
    super(nome, cnpj);
  }

  /**
   * Método que calcula o valor total arrecadado pela imobiliária, somando o valor
   * da comissão de todos os aluguéis mensais dos imóveis
   * 
   * @return double
   */
  public double valorTotalArrecadado() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      valor += imovel.comissaoImobiliaria();
    }

    return valor;
  }
}
