package produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
  private static final int tipo = 2;

  public ProdutoFisico(int id, int quantidade, String nome, BigDecimal precoBase){
    super(id, quantidade, nome, precoBase);
  }

  //Getters
  public int getTipo(){
    return tipo;
  }
}
