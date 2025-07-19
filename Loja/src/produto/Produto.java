import java.math.BigDecimal;
package produto;

public class Produto {
  //Atributos
  private int id;
  private String nome;
  private BigDecimal precoBase

  //Construtor
  public Produto(int id, String nome, BigDecimal precoBase){
    this.id = id;
    this.nome = nome;
    this.precoBase = precoBase;
  }

  //Getters
  public int getId(){
    return id;
  }

  public String getNome(){
    return nome;
  }

  public BigDecimal(){
    return precoBase;
  }

  //Setters
  public void setId(int id){
    this.id = id;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setPrecoBase(BigDecimal precoBase){
    this.precoBase = precoBase;
  }
}
