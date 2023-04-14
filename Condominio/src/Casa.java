
public class Casa extends Imovel {
  private double valorSeguroIncendio;

  public Casa(double valorVenda, String endereco, int anoConstrucao, double valorSeguroIncendio, int quantBeneficios,
      Imobiliaria imobiliaria, Proprietario proprietario) {
    super(valorVenda, endereco, anoConstrucao, imobiliaria, proprietario);
    this.valorSeguroIncendio = valorSeguroIncendio;
    this.quantBeneficios = quantBeneficios;
    this.valorAluguel = calculaAluguelMensal();
  }

  private double calculaAluguelMensal() {
    double valor = (this.valorVenda * 0.005) + (this.valorSeguroIncendio / 12) + (quantBeneficios * 200);
    int idade = 2023 - anoConstrucao;

    while (desconto < 30) {
      for (int i = 0; i < idade / 5; i++) {
        valor *= 0.9;
        this.desconto += 10;
      }
    }

    return valor;
  }

  public double getValorSeguroIncendio() {
    return valorSeguroIncendio;
  }

  @Override
  public double valorAluguelImobiliaria() {
    return (this.valorAluguel - (valorSeguroIncendio / 12)) * 0.12;
  }

  @Override
  public String toString() {
    return "Casa [valorSeguroIncendio=" + valorSeguroIncendio + ", desconto=" + desconto + ", endereco=" + endereco
        + ", quantBeneficios=" + quantBeneficios + ", valorAluguel=" + valorAluguel + ", valorVenda="
        + valorVenda
        + "]";
  }
}
