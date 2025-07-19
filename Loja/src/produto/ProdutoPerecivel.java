package produto;

public class ProdutoPerecivel extends Produto {
  private static final int tipo = 3;

  public ProdutoPerecivel(int id, String nome, BigDecimal precoBase){
    super.Produto(id, nome, precoBase);
  }

  //Getters
  public int getTipo(){
    return tipo;
  }
}
