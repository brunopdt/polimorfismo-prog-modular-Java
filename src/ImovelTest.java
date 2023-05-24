
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ImovelTest {

  @Test
  @SuppressWarnings("unused")
  public void deveAdicionarNaListaDeImoveisProprietario() {
    Imobiliaria imobiliaria = new Imobiliaria("Imobiliaria", "123456789");
    Proprietario proprietario = new Proprietario("Proprietario", "123456789");

    Casa casa = new Casa(100000, "Rua 1", 2000, 1000, 2, imobiliaria, proprietario);
    Apartamento ap = new Apartamento(100000, "Rua 2", 2000, 100, 2, imobiliaria, proprietario);

    assertEquals(2, proprietario.getImoveis().size());
  }

  @Test
  @SuppressWarnings("unused")
  public void deveAdicionarNaListaDeImoveisImobiliaria() {
    Imobiliaria imobiliaria = new Imobiliaria("Imobiliaria", "123456789");
    Proprietario proprietario = new Proprietario("Proprietario", "123456789");

    Casa casa = new Casa(100000, "Rua 1", 2000, 1000, 2, imobiliaria, proprietario);
    Apartamento ap = new Apartamento(100000, "Rua 2", 2000, 100, 2, imobiliaria, proprietario);

    assertEquals(2, imobiliaria.getImoveis().size());
  }

  @Test
  public void deveCalcularOAluguelApartamento() {
    Imobiliaria imobiliaria = new Imobiliaria("Minha Imobiliária", "123");
    Proprietario proprietario = new Proprietario("João Silva", "123");

    Apartamento apartamento = new Apartamento(300000, "Rua das Flores, 123",
        2023, 500, 2, imobiliaria, proprietario);

    double aluguelEsperado = (300000 * 0.004) + 500 + (2 * 200);

    assertEquals(aluguelEsperado, apartamento.getValorAluguel(), 0.01);
  }

  @Test
  public void deveCalcularOAluguelCasa() {
    Imobiliaria imobiliaria = new Imobiliaria("Minha Imobiliária", "123");
    Proprietario proprietario = new Proprietario("João Silva", "123");

    Casa casa = new Casa(300000, "Rua das Flores, 123",
        2018, 12000, 2, imobiliaria, proprietario);

    double aluguelEsperado = ((300000 * 0.005) + 1000 + (2 * 200)) * 0.9;

    assertEquals(aluguelEsperado, casa.getValorAluguel(), 0.01);
  }

  @Test
  @SuppressWarnings("unused")
  public void deveFiltrarPorAnoDeConstrucao() {
    Imobiliaria imobiliaria = new Imobiliaria("Minha Imobiliária", "123");
    Proprietario proprietario = new Proprietario("João Silva", "123");

    Casa casa1 = new Casa(300000, "Rua das Flores, 123",
        2020, 12000, 2, imobiliaria, proprietario);
    Casa casa2 = new Casa(300000, "Rua das Flores, 123",
        2020, 12000, 2, imobiliaria, proprietario);
    Casa casa3 = new Casa(300000, "Rua das Flores, 123",
        2019, 12000, 2, imobiliaria, proprietario);

    assertEquals(2, imobiliaria.imoveisPorAnoDeConstrucao(2020).size());
  }

  @Test
  public void deveImprimirInformacoesDoImovel() {
    Imobiliaria imobiliaria = new Imobiliaria("Quinto Andar", "123");
    Proprietario proprietario = new Proprietario("João Silva", "123");

    Casa casa = new Casa(300000, "Rua das Flores, 123",
        2018, 12000, 2, imobiliaria, proprietario);

    String esperado = "Casa [valorSeguroIncendio=12000.0, desconto=10, endereco=Rua das Flores, 123, quantBeneficios=2, valorAluguel=2610.0, valorVenda=300000.0, nomeProprietario=João Silva, nomeImobiliaria=Quinto Andar]";

    assertEquals(esperado, casa.toString());
  }

  @Test
  public void deveCalcularComissaoDaImobiliaria() {
    Imobiliaria imobiliaria = new Imobiliaria("Quinto Andar", "123");
    Proprietario proprietario = new Proprietario("Jorge", "123");

    Casa casa = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 2, imobiliaria, proprietario);

    double comissaoEsperada = ((300000 * 0.005) + (2 * 200)) * 0.12;

    assertEquals(comissaoEsperada, casa.comissaoImobiliaria(), 0.01);
  }

  @Test
  @SuppressWarnings("unused")
  public void deveCalcularGanhoTotalDaImobiliaria() {
    Imobiliaria imobiliaria = new Imobiliaria("Quinto Andar", "123");
    Proprietario proprietario = new Proprietario("Jorge", "123");

    Casa casa = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 2, imobiliaria, proprietario);
    Casa casa2 = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 2, imobiliaria, proprietario);
    Casa casa3 = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 2, imobiliaria, proprietario);

    double comissaoEsperada = ((300000 * 0.005) + (2 * 200)) * 0.12;
    comissaoEsperada *= 3;

    assertEquals(comissaoEsperada, imobiliaria.valorTotalArrecadado(), 0.01);
  }

  @Test
  @SuppressWarnings("unused")
  public void valorTotalArrecadadoComPropriedades() {
    Imobiliaria imobiliaria = new Imobiliaria("Quinto Andar", "123");
    Proprietario proprietario = new Proprietario("Jorge", "123");

    Casa casa = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 2, imobiliaria, proprietario);
    Casa casa2 = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 2, imobiliaria, proprietario);

    double valorTotal = ((300000 * 0.005) + 1000 + (2 * 200));
    valorTotal *= 2;

    assertEquals(valorTotal, proprietario.valorTotalArrecadado(), 0.01);
  }

  @Test
  @SuppressWarnings("unused")
  public void valorLiquidoAReceberComPropriedades() {
    Imobiliaria imobiliaria = new Imobiliaria("Quinto Andar", "123");
    Proprietario proprietario = new Proprietario("Jorge", "123");

    Casa casa = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 5, imobiliaria, proprietario);
    Casa casa2 = new Casa(300000, "Rua das Flores, 123",
        2023, 12000, 5, imobiliaria, proprietario);

    double valorTotal = ((300000 * 0.005) + (5 * 200));
    double comissao = valorTotal * 0.12;

    assertEquals(2 * (valorTotal - comissao), proprietario.valorLiquidoAReceber(), 0.01);

  }
}