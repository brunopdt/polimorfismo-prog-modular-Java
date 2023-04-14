
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

    for (int i = 0; i < idade / 5; i++) {
      if (desconto < 30) {
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
  public double comissaoImobiliaria() {
    return (this.valorAluguel - condominio) * 0.12;
  }

  @Override
  public String toString() {
    return "Apartamento [condominio=" + condominio + ", desconto=" + desconto + ", endereco=" + endereco
        + ", quantBeneficios=" + quantBeneficios + ", valorAluguel=" + valorAluguel + ", valorVenda="
        + valorVenda + ", nomeProprietario=" + proprietario.getNome() + ", nomeImobiliaria=" + imobiliaria.getNome()
        + "]";
  }

}
