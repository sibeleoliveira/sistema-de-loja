package produto;

import java.math.BigDecimal;

public abstract class Produto {
  //Atributos
  private int id;
  private String nome;
  private BigDecimal precoBase;
  

  //Construtor
  public Produto(int id, String nome, BigDecimal precoBase){
    this.id = id;
    this.nome = nome;
    this.precoBase = precoBase;
  }
  
  public abstract int getTipo();

  //Getters
  public int getId(){
    return id;
  }

  public String getNome(){
    return nome;
  }

  public BigDecimal getPrecoBase(){
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
