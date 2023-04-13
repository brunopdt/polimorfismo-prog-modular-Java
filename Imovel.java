package PM2;

import java.util.List;
import java.util.ArrayList;

public class Imovel {
  private static List<Imovel> imoveis = new ArrayList<Imovel>();
  protected double valorVenda;
  protected String endereco;
  protected int anoConstrucao;
  protected int idade = 2023 - anoConstrucao;
  protected int desconto;
  protected double valorAluguel;
  protected int quantBeneficios;

  public Imovel(double valorVenda, String endereco, int anoConstrucao) {
    this.valorVenda = valorVenda;
    this.endereco = endereco;
    this.anoConstrucao = anoConstrucao;
    this.desconto = 0;
    imoveis.add(this);
  }

  public static List<Imovel> getImoveis() {
    return imoveis;
  }

  public static String imoveisPorAnoDeConstrucao(int ano) {
    List<Imovel> imoveisCorrespondentes = new ArrayList<Imovel>();
    String imoveisString = "";

    for (Imovel imovel : imoveis) {
      if (imovel.anoConstrucao == ano) {
        imoveisCorrespondentes.add(imovel);
      }
    }

    for (Imovel imovel : imoveisCorrespondentes) {
      imoveisString += imovel.toString() + "\n";
    }

    return imoveisString;
  }

  public static double valorTotalArrecadadoPorImobiliaria() {
    double valor = 0;

    for (Imovel imovel : imoveis) {
      if (imovel instanceof Casa) {
        valor += ((Casa) imovel).valorAluguelImobiliaria();
      } else if (imovel instanceof Apartamento) {
        valor += ((Apartamento) imovel).valorAluguelImobiliaria();
      }
    }

    return valor;
  }

}
