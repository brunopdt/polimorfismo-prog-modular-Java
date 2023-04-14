import java.util.List;
import java.util.ArrayList;

public class EntidadeImobiliaria {
  protected List<Imovel> imoveis = new ArrayList<Imovel>();
  protected String nome;
  protected String codigoId;
  protected double valorAlugueis;

  public EntidadeImobiliaria(String nome, String codigoId) {
    this.nome = nome;
    this.codigoId = codigoId;
    valorAlugueis = 0;
  }

  public String imoveisPorAnoDeConstrucao(int ano) {
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

  public void adicionarImovel(Imovel imovel) {
    imoveis.add(imovel);
  }

  public List<Imovel> getImoveis() {
    return imoveis;
  }

  public String getNome() {
    return nome;
  }

  public String getCodigoID() {
    return codigoId;
  }

  public double getValorAlugueis() {
    return valorAlugueis;
  }

}
