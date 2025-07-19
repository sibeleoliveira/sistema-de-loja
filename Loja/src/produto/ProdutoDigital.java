package produto;

public class ProdutoDigital extends Produto{
  //Id do tipo;
  private static final int tipo = 1;

  //Construtor
  public ProdutoDigital(int id, String nome, BigDecimal precoBase){
    super.Produto(id, nome, precoBase);
  }

  public int getTipo(){
    return tipo;
  }
}
