import java.util.List;

public class Pedido extends BaseEntity {
    private String descricao;
    private Cliente cliente; // Relacionamento com Cliente
    private List<Item> itens; // Lista de itens do pedido

    // Construtor
    public Pedido(Long id, String descricao, String status, Cliente cliente) {
        super(id, status);
        this.descricao = descricao;
        this.cliente = cliente;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
