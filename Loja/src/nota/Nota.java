package nota;

import cliente.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;


public class Nota {
	private static final int MAX_ITENS = 50;
	private Cliente cliente;
	private int id;
	private ItemNota[] itens;
	private int contadorItens;
    private final LocalDateTime data;

	public Nota(Cliente cliente, int id) {
        this.id = id;
        this.cliente = cliente;
        this.data = LocalDateTime.now();
        this.itens = new ItemNota[MAX_ITENS];
        this.contadorItens = 0;

	}
    public void adicionarItem(ItemNota item) {
        if (contadorItens < MAX_ITENS) {
            this.itens[contadorItens++] = item;
        } else {
            System.out.println("Erro: Limite máximo de itens na nota atingido!");
        }
    }
    
    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < contadorItens; i++) {
            total = total.add(itens[i].subtotal());
        }
        return total;
    }
    public void exibirResumo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("\n==========================================================");
        System.out.println("                    NOTA DE COMPRA");
        System.out.println("==========================================================");
        System.out.printf("ID da Nota: %d\n", this.id);
        System.out.printf("Data: %s\n", this.data.format(formatter));
        System.out.println("----------------------------------------------------------");
        System.out.printf("Cliente: %s (%s)\n", this.cliente.getNome(), this.cliente.getTipo());
        System.out.println("----------------------------------------------------------");
        System.out.println("ITENS DA NOTA:");
        for (int i = 0; i < contadorItens; i++) {
            System.out.printf("Produto: %s | Qtd: %3d | Preço Unit.: R$ %.2f | Subtotal: R$ %.2f\n",
                    itens[i].getProduto().getNome(), itens[i].getQuant(), itens[i].getPreco(), itens[i].subtotal());
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("VALOR TOTAL: R$ %.2f\n", this.getValorTotal());
        System.out.println("==========================================================");
    }

}
