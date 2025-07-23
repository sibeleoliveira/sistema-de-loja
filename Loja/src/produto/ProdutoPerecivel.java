package produto;

import java.math.BigDecimal; 

public class ProdutoPerecivel extends Produto {
  private static final int tipo = 3;
  private int validadeDias;

  public ProdutoPerecivel(int id, int quantidade, String nome, BigDecimal precoBase, int validadeDias){
    super(id, quantidade, nome, precoBase);
    this.validadeDias = validadeDias;
  }

  //Getters
  public int getTipo(){return tipo;}
  public int getValidadeDias(){return validadeDias;}

  //Setters
  public void setValidadeDias(int validadeDias){this.validadeDias = validadeDias;}
}
