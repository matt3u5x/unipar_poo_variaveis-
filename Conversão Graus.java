import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int valorCelsius = 0;
        
        double valorFahrenheit = 0.0;
        
     
        System.out.println("Informe o valor para converter");
        valorCelsius = scanner.nextInt();
        
        
        
        valorFahrenheit = (valorCelsius * 9/5) + 32;
        
        System.out.println("o valor convertido eh " + valorFahrenheit);

        scanner.close();
        
        
        
    }
}
