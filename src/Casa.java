
public class Casa extends Imovel {
  private double valorSeguroIncendio;

  public Casa(double valorVenda, String endereco, int anoConstrucao, double valorSeguroIncendio, int quantBeneficios,
      Imobiliaria imobiliaria, Proprietario proprietario) {
    super(valorVenda, endereco, anoConstrucao, imobiliaria, proprietario);
    this.valorSeguroIncendio = valorSeguroIncendio;
    this.quantBeneficios = quantBeneficios;
    this.valorAluguel = calculaAluguelMensal();
  }

  /**
   * Método que calcula o valor do aluguel mensal da casa, considerando o
   * valor de venda, valor anual do seguro do incêndio, benefícios e idade do
   * imóvel
   * 
   * @return double
   */
  private double calculaAluguelMensal() {
    double valor = (this.valorVenda * 0.005) + (this.valorSeguroIncendio / 12) + (quantBeneficios * 200);
    int idade = 2023 - anoConstrucao;

    for (int i = 0; i < idade / 5; i++) {
      if (desconto < 30) {
        valor *= 0.9;
        this.desconto += 10;
      }
    }

    return valor;
  }

  /**
   * Método que calcula a comissão da imobiliária (12%), excluindo o valor do
   * seguro de incêndio
   * 
   * @Override comissaoImobiliaria()
   * @return double
   */
  @Override
  public double comissaoImobiliaria() {
    return (this.valorAluguel - (valorSeguroIncendio / 12)) * 0.12;
  }

  /**
   * Método toString.
   * <p>
   * Informa o valor do seguro, desconto, endereço, quantidade de benefícios,
   * valor do aluguel, valor de venda, nome do proprietário e nome da imobiliária,
   * respectivamente
   * 
   * @Override toString()
   * @return String
   */
  @Override
  public String toString() {
    return "Casa [valorSeguroIncendio=" + valorSeguroIncendio + ", desconto=" + desconto + ", endereco=" + endereco
        + ", quantBeneficios=" + quantBeneficios + ", valorAluguel=" + valorAluguel + ", valorVenda="
        + valorVenda + ", nomeProprietario=" + proprietario.getNome() + ", nomeImobiliaria=" + imobiliaria.getNome()
        + "]";
  }

  public double getValorSeguroIncendio() {
    return valorSeguroIncendio;
  }
}
