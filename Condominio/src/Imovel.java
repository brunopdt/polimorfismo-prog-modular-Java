
public abstract class Imovel {
  protected double valorVenda;
  protected String endereco;
  protected int anoConstrucao;
  protected int desconto;
  protected double valorAluguel;
  protected int quantBeneficios;
  protected Imobiliaria imobiliaria;
  protected Proprietario proprietario;

  public Imovel(double valorVenda, String endereco, int anoConstrucao, Imobiliaria imobiliaria,
      Proprietario proprietario) {
    this.valorVenda = valorVenda;
    this.endereco = endereco;
    this.anoConstrucao = anoConstrucao;
    this.desconto = 0;

    this.imobiliaria = imobiliaria;
    this.proprietario = proprietario;

    imobiliaria.adicionarImovel(this);
    proprietario.adicionarImovel(this);
  }

  public double getValorAluguel() {
    return valorAluguel;
  }

  /**
   * Método abstrato para override nas classes filhas
   * 
   * @return double
   */
  public abstract double comissaoImobiliaria();

}
