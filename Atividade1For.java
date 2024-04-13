public class Main {
    
    public static void main(String[] args){


        for(int numero = 1; numero < 50; numero++){

            if((numero % 3 == 0) && (numero % 5 ==0)){
                System.out.println(numero + " FizzBuzz");
            }else if(numero % 3 == 0){
                System.out.println(numero + " Fizz");
            } else if(numero % 5 == 0){
                System.out.println(numero + " Buzz");
            }else{
                System.out.println(numero);
            }

        }


    }

} 
