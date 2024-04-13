import java.util.Scanner;
public class For2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int patos;
        int numeroPatos;

        System.out.println("Informe o número de patos!");
        numeroPatos = sc.nextInt();

        for (patos = numeroPatos; patos > 0; patos--) {
            System.out.println(patos + " Patinhos foram passear. Além das montanhas para brincar. A mamãe gritou: Quá, quá, quá, quá." +
                    "mas só " + (patos - 1) + " patinhos voltaram de lá.");
        }
        System.out.println();
        System.out.println("A mamãe patinha foi procurar. Além das montanhas na beira do mar. A mamãe gritou: Quá, quá, quá,quá." +
                " E os " + numeroPatos + " patinhos voltaram de lá");


    }
}
