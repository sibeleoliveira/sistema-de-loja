package produto;

import java.math.BigDecimal; 

public class ProdutoPerecivel extends Produto {
  private static final int tipo = 3;
  private double validadeDias;

  public ProdutoPerecivel(int id, int quantidade, String nome, BigDecimal precoBase, double validadeDias){
    super(id, quantidade, nome, precoBase);
    this.validadeDias = validadeDias;
  }

  //Getters
  public int getTipo(){return tipo;}
  public double getValidadeDias(){return validadeDias;}
  public double getEspecifico(){return validadeDias;}

  //Setters
  public void setValidadeDias(int validadeDias){this.validadeDias = validadeDias;}
}
