package produto;

public class ProdutoFisico extends Produto {
  private static final int tipo = 2;

  public ProdutoFisico(int id, String nome, BigDecimal precoBase){
    super.Produto(id, nome, precoBase);
  }

  //Getters
  public int getTipo(){
    return tipo;
  }
}
