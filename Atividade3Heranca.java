package br.unipar;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.facaSom();

        Cachorro cachorro = new Cachorro();
        cachorro.facaSom();

        Calculadora calculadora = new Calculadora();
        int sum1 = calculadora.add(1,2);
        System.out.println(sum1);
        int sum2 = calculadora.add(1,2,3);
        System.out.println(sum2);
        double sum3 = calculadora.add(1.5,2.5);
        System.out.println(sum3);
    }
}

/*Explicação: Override é usada para indicar que o método facaSom() na classe Gato está sobrescrevendo o método facaSom() da classe Animal, que é a classe pai de Gato.
    A classe pai, temos o método facoSom(), que chama "O animal faz o som" assim que chamado. Na classe Gato temos outro método facoSom() que representa o "Meow" assim que chamado.
    O Override antes do método facaSom() na classe Gato indica que este método está substituindo o método facaSom() da classe Animal.
    Isso significa que, quando você tem um objeto da classe Gato e chama o método facaSom(), o método facaSom() da classe Gato será executado, não o da classe Animal.
    No método main(), um objeto chamado animal é criado a partir da classe Animal e um objeto chamado gato é criado a partir da classe Gato. Quando o método facaSom() é chamado no objeto animal, a saída é “O animal faz o som”.
    Isso ocorre porque esse é o comportamento definido para o método facaSom() na classe Animal. No entanto, quando o método facaSom() é chamado no objeto gato, a saída é “Meow”.
    Isso ocorre porque a classe Gato, que é uma subclasse da classe Animal, sobrescreveu o método facaSom() para exibir “Meow” em vez de “O animal faz o som”.*/
    
------------

package br.unipar;

public class Animal {
    public void facaSom(){
        System.out.println("Som");
    }
}

------------
------------

  package br.unipar;

public class Cachorro extends Animal {
    @Override
    public void facaSom(){
        System.out.println("Au-ar-au");
    }

}

------------

package br.unipar;

public class Calculadora {
    public int add(int a, int b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public double add(double a, double b) {
        return a + b;
    }
}

/*Explicação: A sobrecarga é aplicada na classe Calculadora.
    O método add(int a, int b) recebe dois inteiros e retorna a soma deles.
    O método add(int a, int b, int c) também se chama add, mas recebe três inteiros e retorna a soma deles.
    O método add(double a, double b) é mais um método add, mas desta vez recebe dois números de ponto flutuante (double) e retorna a soma deles.
    Cada um desses métodos add realiza a mesma operação básica (adição), mas eles são aplicados a diferentes números de argumentos ou tipos de argumentos.*/

------------
------------    

/* Teste Animal */
    
package br.unipar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AnimalTest {

    @Test
    public void testFacaSom() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Animal animal = new Animal();
        animal.facaSom();

        System.setOut(originalOut);

        String output = outputStream.toString().trim();
        assertEquals("Som", output);
    }
}

------------

 /* Teste Calculadora */   

package br.unipar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testAddDoisNumeros() {
        Calculadora calc = new Calculadora();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testAddTresNumeros() {
        Calculadora calc = new Calculadora();
        int result = calc.add(1, 2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testAddDoisDouble() {
        Calculadora calc = new Calculadora();
        double result = calc.add(2.5, 3.5);
        assertEquals(6.0, result);
    }

    @Test
    public void testAddDoisNumerosComZero() {
        Calculadora calc = new Calculadora();
        int result = calc.add(0, 5);
        assertEquals(5, result);
    }

    @Test
    public void testAddNegativosNumeros() {
        Calculadora calc = new Calculadora();
        int result = calc.add(-1, -2);
        assertEquals(-3, result);
    }

    @Test
    public void testAddNumerosMisturados() {
        Calculadora calc = new Calculadora();
        int result = calc.add(-1, 2);
        assertEquals(1, result);
    }

    @Test
    public void testAddDoublesNegativosPositivos() {
        Calculadora calc = new Calculadora();
        double result = calc.add(-2.5, 3.5);
        assertEquals(1.0, result);
    }

    @Test
    public void testAddComDoubleZero() {
        Calculadora calc = new Calculadora();
        double result = calc.add(0.0, 5.0);
        assertEquals(5.0, result);
    }
}
