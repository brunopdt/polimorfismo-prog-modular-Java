
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ImovelTest {

  @Test
  public void deveAdicionarNaListaDeImoveisProprietario() {
    Imobiliaria imobiliaria = new Imobiliaria("Imobiliaria", "123456789");
    Proprietario proprietario = new Proprietario("Proprietario", "123456789");
    Casa casa = new Casa(100000, "Rua 1", 2000, 1000, 2, imobiliaria, proprietario);
    Apartamento ap = new Apartamento(100000, "Rua 2", 2000, 100, 2, imobiliaria, proprietario);
    assertEquals(2, proprietario.getImoveis().size());
  }

  @Test
  public void deveAdicionarNaListaDeImoveisImobiliaria() {
    Imobiliaria imobiliaria = new Imobiliaria("Imobiliaria", "123456789");
    Proprietario proprietario = new Proprietario("Proprietario", "123456789");
    Casa casa = new Casa(100000, "Rua 1", 2000, 1000, 2, imobiliaria, proprietario);
    Apartamento ap = new Apartamento(100000, "Rua 2", 2000, 100, 2, imobiliaria, proprietario);

    assertEquals(2, imobiliaria.getImoveis().size());
  }

  /*
   * @Test
   * public void deveCalcularOAluguel() {
   * Imobiliaria imobiliaria = new Imobiliaria("Minha Imobiliária", "123");
   * Proprietario proprietario = new Proprietario("João Silva", "123");
   * Apartamento apartamento = new Apartamento(300000, "Rua das Flores, 123",
   * 2023, 500, 2, imobiliaria, proprietario);
   * 
   * double aluguelEsperado = (300000 * 0.004) + 500 + (2 * 200);
   * 
   * assertEquals(aluguelEsperado, apartamento.getValorAluguel(), 0.01);
   * }
   */

}