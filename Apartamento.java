package PM2;

public class Apartamento extends Imovel {
  private double condominio;

  public Apartamento(double valorVenda, String endereco, int anoConstrucao, double condominio, int quantBeneficios) {
    super(valorVenda, endereco, anoConstrucao);
    this.condominio = condominio;
    this.quantBeneficios = quantBeneficios;
    this.valorAluguel = calculaAluguelMensal();
  }

  private double calculaAluguelMensal() {
    double valor = (this.valorVenda * 0.4) + condominio + (quantBeneficios * 200);

    if (desconto < 30) {
      for (int i = 0; i < idade / 5; i++) {
        valor *= 0.95;
        this.desconto += 5;
      }
    }

    return valor;
  }

  public double getValorAluguel() {
    return valorAluguel;
  }

  public double valorAluguelImobiliaria() {
    return (this.valorAluguel - condominio) * 0.12;
  }

  @Override
  public String toString() {
    return "Apartamento [valorCondominio=" + condominio + ", desconto=" + desconto + ", endereco=" + endereco
        + ", idade="
        + idade + ", quantBeneficios=" + quantBeneficios + ", valorAluguel=" + valorAluguel + ", valorVenda="
        + valorVenda
        + "]";
  }

}
