package produto;

import java.math.BigDecimal;

public class Produto {
  //Atributos
  private int id, quantidade, tipo;
  private String nome;
  private BigDecimal precoBase;
  

  //Construtor
  public Produto(int id, int quantidade, String nome, BigDecimal precoBase){
    this.id = id;
    this.quantidade = quantidade;
    this.nome = nome;
    this.precoBase = precoBase;
  }

  //Getters
  public int getId(){
    return id;
  }

  public int getQuantidade(){
    return quantidade;
  }

  public String getNome(){
    return nome;
  }

  public BigDecimal getPrecoBase(){
    return precoBase;
  }

  public int getTipo(){
    return tipo;
  }

  //Setters
  public void setId(int id){
    this.id = id;
  }

  public void setQuantidade(int quantidade){
    this.quantidade = quantidade;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setPrecoBase(BigDecimal precoBase){
    this.precoBase = precoBase;
  }
  public void reduzQuantidade (int quant) {
	  this.quantidade-=quant;
  }
  
}
