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

  /**
   * Método que filtra os imóveis de um proprietário ou imobiliária pelo ano de
   * construção do mesmo
   * 
   * @param ano
   * @return List<Imovel>: lista dos imóveis correspondentes
   */
  public List<Imovel> imoveisPorAnoDeConstrucao(int ano) {
    List<Imovel> imoveisCorrespondentes = new ArrayList<Imovel>();

    for (Imovel imovel : imoveis) {
      if (imovel.anoConstrucao == ano) {
        imoveisCorrespondentes.add(imovel);
      }
    }

    return imoveisCorrespondentes;
  }

  /**
   * Adiciona o imóvel à lista de imóveis da imobiliária ou proprietário
   * 
   * @param imovel
   * @return void
   */
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
