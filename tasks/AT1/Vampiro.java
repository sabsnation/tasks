public class Vampiro {
    // Atributos
    private final String nome;  // nome é final
    private final int idade;    // idade é final
    private int forca;
    private int sedeDeSangue;
    private boolean transformado;

    // Construtor
    public Vampiro(String nome, int idade, int forca) {
        this.nome = nome;
        this.idade = idade;
        this.forca = forca;
        this.sedeDeSangue = 0;
        this.transformado = false;
    }

    // Métodos
    public void transformar() {
        if (!this.transformado) {
            this.transformado = true;
            System.out.println(nome + " foi transformado em vampiro!");
        } else {
            System.out.println(nome + " já é um vampiro.");
        }
    }

    public void beberSangue(int quantidade) {
        this.forca += quantidade;
        this.sedeDeSangue -= quantidade;
        if (this.sedeDeSangue < 0) this.sedeDeSangue = 0;
        System.out.println(nome + " bebeu " + quantidade + " unidades de sangue. Força: " + this.forca + ", Sede de Sangue: " + this.sedeDeSangue);
    }

    public int atacar() {
        if (this.forca > 10) {
            this.forca -= 10;
            int dano = 20;
            System.out.println(nome + " atacou e causou " + dano + " de dano.");
            return dano;
        } else {
            System.out.println(nome + " está muito fraco para atacar.");
            return 0;
        }
    }

    public boolean estaComSede() {
        return this.sedeDeSangue > 50;
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
        System.out.println("Força: " + this.forca);
        System.out.println("Sede de Sangue: " + this.sedeDeSangue);
        System.out.println("Transformado: " + (this.transformado ? "Sim" : "Não"));
    }
}
