
public class Apartamento extends Imovel {
  private double condominio;

  public Apartamento(double valorVenda, String endereco, int anoConstrucao, double condominio, int quantBeneficios,
      Imobiliaria imobiliaria, Proprietario proprietario) {
    super(valorVenda, endereco, anoConstrucao, imobiliaria, proprietario);
    this.condominio = condominio;
    this.quantBeneficios = quantBeneficios;
    this.valorAluguel = calculaAluguelMensal();
  }

  private double calculaAluguelMensal() {
    double valor = (this.valorVenda * 0.004) + condominio + (quantBeneficios * 200);
    int idade = 2023 - anoConstrucao;

    while (desconto < 30) {
      for (int i = 0; i < idade / 5; i++) {
        valor *= 0.95;
        this.desconto += 5;
      }
    }

    return valor;
  }

  public double getValorCondominio() {
    return condominio;
  }

  @Override
  public double valorAluguelImobiliaria() {
    return (this.valorAluguel - condominio) * 0.12;
  }

  @Override
  public String toString() {
    return "Apartamento [valorCondominio=" + condominio + ", desconto=" + desconto + ", endereco=" + endereco
        + ", quantBeneficios=" + quantBeneficios + ", valorAluguel=" + valorAluguel + ", valorVenda="
        + valorVenda
        + "]";
  }

}
