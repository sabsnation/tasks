import java.util.List;

public class Restaurante {
    private String nome;
    private List<Produto> produtos;

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
