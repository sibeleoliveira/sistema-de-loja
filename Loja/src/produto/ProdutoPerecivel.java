package produto;

import java.math.BigDecimal; 

public class ProdutoPerecivel extends Produto {
  private static final int tipo = 3;

  public ProdutoPerecivel(int id, int quantidade, String nome, BigDecimal precoBase){
    super(id, quantidade, nome, precoBase);
  }

  //Getters
  public int getTipo(){
    return tipo;
  }

}
