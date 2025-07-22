package nota;

import produto.*;
import java.math.BigDecimal;


public class ItemNota {
	private Produto produto;
	private BigDecimal preco;
	private int quant;
	
	public ItemNota (Produto produto, int quant) {
		this.produto = produto;
		this.quant = quant;
		this.preco = produto.getPrecoBase();
		this.produto.reduzQuantidade(quant);
	}
    public Produto getProduto() {
        return produto;
    }

    public int getQuant() {
        return quant;
    }

    public BigDecimal getPreco() {
        return preco;
    }
	
	public BigDecimal subtotal () {
	    BigDecimal subtotal = this.preco.multiply(BigDecimal.valueOf(this.quant));
		return subtotal;
	}
}




