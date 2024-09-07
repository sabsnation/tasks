import java.util.ArrayList;

public class Nomes {
    public static void main(String[] args) {
        // Criando o ArrayList com 5 nomes
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("João");
        nomes.add("Maria");
        nomes.add("Talles");
        nomes.add("Ana");
        nomes.add("Carlos");

        // Removendo o segundo nome
        nomes.remove(1);

        // Imprimindo todos os nomes após a remoção do segundo
        System.out.println("Lista após remover o segundo nome: " + nomes);

        // Removendo o terceiro nome
        nomes.remove(2);

        // Imprimindo os valores após remover o terceiro nome
        System.out.println("Lista após remover o terceiro nome: " + nomes);

        // Validando se a primeira posição é "Talles"
        if (nomes.get(0).equals("Talles")) {
            System.out.println("O primeiro nome é Talles.");
        } else {
            System.out.println("O primeiro nome não é Talles.");
        }
    }
}
