import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double valorUm = 0.0;
        double valorDois = 0.0;
        double valorTres = 0.0;
        double valorQuatro = 0.0;
     
        System.out.println("Informe o valor um");
        valorUm = scanner.nextDouble();
        
        System.out.println("Infome o valor dois");
        valorDois = scanner.nextDouble();
        
        System.out.println("Infome o valor tres");
        valorTres = scanner.nextDouble();
        
        System.out.println("Infome o valor quatro");
        valorQuatro = scanner.nextDouble();
        
        
        double valorDiv = (valorUm + valorDois + valorTres + valorQuatro) / 4;
        
        
        System.out.println("o valor da sub he " + valorDiv);

        scanner.close();
        
        
        
    }
}
