public class Cliente extends BaseEntity {
    private String nome;

    // Construtor
    public Cliente(Long id, String nome, String status) {
        super(id, status);
        this.nome = nome;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
