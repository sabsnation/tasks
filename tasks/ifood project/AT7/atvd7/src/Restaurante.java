import java.util.List;

public class Restaurante {
    private final String nome;
    private final List<Produto> produtos;

    public Restaurante(String nome, List<Produto> produtos) {
        this.nome = nome;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
