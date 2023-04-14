
public class Apartamento extends Imovel {
  private double condominio;

  public Apartamento(double valorVenda, String endereco, int anoConstrucao, double condominio, int quantBeneficios,
      Imobiliaria imobiliaria, Proprietario proprietario) {
    super(valorVenda, endereco, anoConstrucao, imobiliaria, proprietario);
    this.condominio = condominio;
    this.quantBeneficios = quantBeneficios;
    this.valorAluguel = calculaAluguelMensal();
  }

  /**
   * Método que calcula o valor do aluguel mensal do apartamento, considerando o
   * valor de venda, condomínio, benefícios e idade do imóvel
   * 
   * @return double
   */
  private double calculaAluguelMensal() {
    double valor = (this.valorVenda * 0.004) + condominio + (quantBeneficios * 200);
    int idade = 2023 - anoConstrucao;

    for (int i = 0; i < idade / 5; i++) {
      if (desconto < 30) {
        valor *= 0.95;
        this.desconto += 5;
      }
    }

    return valor;
  }

  /**
   * Método que calcula a comissão da imobiliária (12%), excluindo o valor do
   * condomínio
   * 
   * @Override comissaoImobiliaria()
   * @return double
   */
  @Override
  public double comissaoImobiliaria() {
    return (this.valorAluguel - condominio) * 0.12;
  }

  /**
   * Método toString
   * <p>
   * Informa o condomínio, desconto, endereço, quantidade de benefícios, valor do
   * aluguel, valor de venda, nome do proprietário e nome da imobiliária,
   * respectivamente
   * 
   * @Override toString()
   * @return String: dados do Apartamento
   */
  @Override
  public String toString() {
    return "Apartamento [condominio=" + condominio + ", desconto=" + desconto + ", endereco=" + endereco
        + ", quantBeneficios=" + quantBeneficios + ", valorAluguel=" + valorAluguel + ", valorVenda="
        + valorVenda + ", nomeProprietario=" + proprietario.getNome() + ", nomeImobiliaria=" + imobiliaria.getNome()
        + "]";
  }

  public double getValorCondominio() {
    return condominio;
  }

}
