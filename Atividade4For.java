import java.util.Scanner;
public class numeros20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeros = 0;

        for (int n = 1; n <= 20; n++) {
            System.out.println("Informe qualquer número: ");
            numeros = sc.nextInt();

            if (numeros >= 0 && numeros <= 100) {
                System.out.println("Esses números estão em 0 e 100: " + numeros);
            } else if (numeros >= 101 && numeros <= 200) {
                System.out.println("Esses números estão entre 101 e 200: " + numeros);
            } else {
                System.out.println("Estes números são maiores de 200: " + numeros);
            }
        }
    }
