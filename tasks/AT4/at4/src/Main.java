public class Main {
    public static void main(String[] args) {
       
        Pessoa pessoa1 = new Pessoa("Stanford Pines", "63", "Masculino", "Estadunidense", "Mistery Shack-Gravity Falls", "4637944855", "needhelp@gmail.com", "123.456.789-00", "GF-12.345.678", "Cientista");

        Pessoa pessoa2 = new Pessoa("Bill Cipher", "muitos para serem listados", "Masculino", "Flatland", "Mundo dos pesadelos, 666", "666666666", "letsmakeadeal!@email.com", "987.654.321-00", "@@-98.765.432", "Musa");

        pessoa1.exibirDados();
        System.out.println();
        pessoa2.exibirDados();
    }
}
