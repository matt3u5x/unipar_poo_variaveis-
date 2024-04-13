import java.util.Scanner;
public class AnosemDias {

    public static void main(String[] args) {

        int anos, meses, dias, total;
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe quantos anos desejar: ");
        anos = sc.nextInt();

        System.out.println("Informe quantos meses desejar: ");
        meses = sc.nextInt();

        System.out.println("Informe quantos dias desejar: ");
        dias = sc.nextInt();

        total=((anos * 365) + (meses * 30) + dias);
        System.out.println("O total de em dias de " + anos + " anos, " + meses + " meses e " + dias + " dias é: " + total);

    }
}
