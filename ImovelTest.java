package PM2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImovelTest {

  @Test
  public void deveAdicionarNaListaDeImoveis() {
    Casa casa = new Casa(1000000, "rua 2", 1975, 1000, 3);
    Casa casa2 = new Casa(1000000, "rua 2", 1975, 1000, 3);
    Apartamento ap = new Apartamento(1000000, "rua 2", 1975, 1000, 3);

    assertEquals(3, Imovel.getImoveis().size());
  }

}
