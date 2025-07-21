package produto;

import java.math.BigDecimal; 

public class ProdutoDigital extends Produto{
  //Id do tipo;
  private static final int tipo = 1;

  //Construtor
  public ProdutoDigital(int id, int quantidade, String nome, BigDecimal precoBase){
    super(id, quantidade, nome, precoBase);
  }

  public int getTipo(){
    return tipo;
  }
}
