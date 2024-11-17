import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<String> itens;
    private double total;

    public Carrinho() {
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarItem(String item, double preco) {
        itens.add(item);
        total += preco;
    }

    public void exibirCarrinho() {
        System.out.println("\n--- Carrinho ---");
        for (String item : itens) {
            System.out.println(item);
        }
        System.out.printf("Total: R$ %.2f%n", total);
    }
}
