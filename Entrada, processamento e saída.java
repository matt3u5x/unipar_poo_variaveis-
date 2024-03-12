import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double valorUm = 0.0;
        double valorDois = 0.0;
        double valorTres = 0.0;
     
        System.out.println("Informe o valor um");
        valorUm = scanner.nextDouble();
        
        System.out.println("Infome o valor dois");
        valorDois = scanner.nextDouble();
        
        System.out.println("informe o valor tes");
        valorTres = scanner.nextDouble();
        
        double valorSoma = valorUm + valorDois + valorTres;
        
        System.out.println("o valor somado he " + valorSoma);

        scanner.close();
