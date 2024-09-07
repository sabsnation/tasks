import java.util.Scanner;

public class XY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de x: ");
        int x = scanner.nextInt();
        
        System.out.print("Digite o valor de y: ");
        int y = scanner.nextInt();

        System.out.println("O maior valor é: " + (x > y ? x : y));

        scanner.close();
    }
}
