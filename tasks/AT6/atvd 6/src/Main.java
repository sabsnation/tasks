import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Criando cliente
        Cliente cliente = new Cliente(1L, "João", BaseEntity.STATUS_ATIVO);

        // Criando pedido e associando ao cliente
        Pedido pedido = new Pedido(1L, "Pedido de Compra", BaseEntity.STATUS_ATIVO, cliente);

        // Criando itens e associando ao pedido
        Item item1 = new Item(1L, "Produto A", 50.0);
        Item item2 = new Item(2L, "Produto B", 30.0);

        // Associando itens ao pedido
        pedido.setItens(Arrays.asList(item1, item2)); // Alterado para Arrays.asList

        // Exibindo informações
        System.out.println("Pedido do cliente: " + pedido.getCliente().getNome());
        System.out.println("Itens no pedido:");
        for (Item item : pedido.getItens()) {
            System.out.println(" - " + item.getNome() + ": " + item.getPreco());
        }
    }
}
