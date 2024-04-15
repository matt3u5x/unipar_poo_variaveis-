package Objetos;

public class ContaBancaria {

   public double saldo;
   public String numeroConta = "193";
   public double depositar;
   public double sacar;

}

package Main;

import Objetos.ContaBancaria;
import java.util.Scanner;

public class ForAtvdd6 {
    public static void main(String[] args) {
        ContaBancaria cb = new ContaBancaria();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while(true) {

        System.out.println();
        System.out.println("Número da conta: " + cb.numeroConta);
        System.out.println("Bem vindo ao Banco JusBank!");
        System.out.println("Escolha uma opção para continuar!");
        System.out.println("1 - Depositar Dinheiro");
        System.out.println("2 - Sacar Dinheiro");
        System.out.println("3 - Consultar Conta");
        System.out.println("4 - Sair");
        System.out.println();
        opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Você acaba de depositar 1000R$ na sua conta!");
                        cb.depositar = (cb.depositar + 1000);
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("Você acaba de sacar 1000R$ na sua conta!");
                        cb.depositar = (cb.depositar - 1000);
                        System.out.println();
                        break;

                    case 3:
                        System.out.println("Você tem  na sua conta: ");
                        System.out.println(cb.depositar);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Obrigado por utilizar o JusBank!");
                        System.out.println();
                        return;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        System.out.println();


                }

        }

    }
}
