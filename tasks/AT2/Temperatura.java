import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        // Cria o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicita ao usuário que insira a temperatura
            System.out.print("Digite a temperatura (em graus): ");
            int temperatura = scanner.nextInt();

            // Verifica se o clima está quente ou frio
            if (temperatura > 30) {
                System.out.println("O clima está quente.");
            } else {
                System.out.println("O clima está frio.");
            }

        } finally {
            // Fecha o Scanner
            scanner.close();
        }
    }
}

