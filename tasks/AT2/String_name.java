import java.util.Scanner;

public class String_name {
    public static void main(String[] args) {
        // Cria o Scanner para leitura da string
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicita ao usuário que insira uma string
            System.out.print("Digite uma string: ");
            String input = scanner.nextLine();

            // a) Número de caracteres da string
            int numCaracteres = input.length();
            System.out.println("Número de caracteres: " + numCaracteres);

            // b) String com todas as letras em maiúsculo
            String maiuscula = input.toUpperCase();
            System.out.println("String em maiúsculas: " + maiuscula);

            // c) Número de vogais na string
            int numVogais = contarVogais(input);
            System.out.println("Número de vogais: " + numVogais);

            // d) Verificar se a string começa com "UNI" (ignorando maiúsculas/minúsculas)
            if (input.toUpperCase().startsWith("UNI")) {
                System.out.println("A string começa com 'UNI'.");
            } else {
                System.out.println("A string não começa com 'UNI'.");
            }

            // e) Verificar se a string termina com "RIO" (ignorando maiúsculas/minúsculas)
            if (input.toUpperCase().endsWith("RIO")) {
                System.out.println("A string termina com 'RIO'.");
            } else {
                System.out.println("A string não termina com 'RIO'.");
            }

        } finally {
            // Fecha o Scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    // Método para contar o número de vogais em uma string
    public static int contarVogais(String str) {
        int count = 0;
        String vogais = "AEIOUaeiou";

        for (int i = 0; i < str.length(); i++) {
            if (vogais.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }

        return count;
    }
}
