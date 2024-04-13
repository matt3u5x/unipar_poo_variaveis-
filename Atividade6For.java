private class ContaBancaria {

    double saldo;
    String numeroConta;

}
public static class ContaBancariaex {

    double depositar;
    double sacar;
    double consultarSaldo;

    }

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
public class ContaBancariaEx {
    public static void main(String[] args) {

        ContaBancariaex conta = new ContaBancariaex();
        ContaBancaria contap = new ContaBancaria();
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("O que deseja fazer?");
        System.out.println("1 - Depositar Dinheiro");
        System.out.println("2 - Sacar Dinheiro");
        System.out.println("3 - Consultar Conta");

        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Quanto deseja depositar?");
                conta.depositar = sc.nextDouble();
                contap.saldo = contap.saldo + conta.depositar;
                break;

            case 2:
                System.out.println("Quanto deseja sacar?");
                conta.sacar = sc.nextDouble();
                if (contap.saldo > 0){
                    contap.saldo = contap.saldo - conta.sacar;
                    break;
                } else {
                    System.out.println("Não há nenhum dinheiro para ser sacado!");
                    break;
                }

        case 3:
        System.out.println(contap.saldo);
        break;
    }
        }
}
