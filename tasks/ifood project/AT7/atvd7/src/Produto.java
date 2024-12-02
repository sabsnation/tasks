import java.util.List;

public class Produto {
    private final String nome;
    private final double preco;
    private final List<Adicional> adicionais;

    public Produto(String nome, double preco, List<Adicional> adicionais) {
        this.nome = nome;
        this.preco = preco;
        this.adicionais = adicionais;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }
}

