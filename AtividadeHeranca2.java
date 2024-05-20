package br.unipar;

public class ContaCorrente extends HerancaContaBancaria {
    @Override
    public boolean saque(Double valor) {

        if(saldo >= valor){
            saldo -= valor;
            return true;
        }

        return false;
    }
}

----------

package br.unipar;

public class ContaPoupanca extends HerancaContaBancaria {

    @Override
    public boolean saque(Double valor) {
        if ((saldo - valor - 5) >= 0){
            saldo -=  5;
            saldo -= valor;

            return true;
        }

        return false;
    }

}

----------

package br.unipar;

import java.util.UUID;

abstract class HerancaContaBancaria implements InterfaceContaBancaria {

    protected Double saldo;
    private String numeroConta;


    public HerancaContaBancaria() {
        saldo = 0d;
        numeroConta = UUID.randomUUID().toString();
    }


    @Override
    public Double obterSaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;

    }

    @Override
    public String retornarNumeroConta() {
        return numeroConta;
    }
}

----------

package br.unipar;

public interface InterfaceContaBancaria {

    Double obterSaldo();
    void depositar(Double valor);
    String retornarNumeroConta();
    boolean saque(Double valor);

}

----------

package br.unipar;

public class Main {
    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente();

        contaCorrente.depositar(1000d);

        System.out.println("Saldo é: " + contaCorrente.obterSaldo());
        System.out.println("Numero da conta é: " + contaCorrente.retornarNumeroConta());


    }
}

----------

import br.unipar.ContaCorrente;
import br.unipar.ContaPoupanca;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    @Test
    public void testeDepositoContaCorrente(){

        ContaCorrente conta = new ContaCorrente();
        conta.depositar(5000d);

        assertEquals(conta.obterSaldo(),5000);

    }

    @Test
    public void testSaqueContaCorrente(){
    ContaCorrente conta = new ContaCorrente();
    conta.depositar(3000d);
    boolean validacao = conta.saque(1500d);

    assertTrue(validacao);
    assertEquals(1500,conta.obterSaldo());

    }

    @Test
    public void testSaqueMaiorSaldoContaCorrente() {
        ContaCorrente conta = new ContaCorrente();
        conta.depositar(3000d);
        boolean validacao = conta.saque(4500d);

        assertFalse(validacao);
        assertEquals(3000, conta.obterSaldo());

    }

    @Test
    public void testSaqueMaiorSaldoContaPoupanca() {
        ContaPoupanca conta = new ContaPoupanca();
        conta.depositar(3000d);
        boolean validacao = conta.saque(3000d);

        assertFalse(validacao);
        assertEquals(3000, conta.obterSaldo());
    
    }
}

----------

import br.unipar.ContaCorrente;
import br.unipar.ContaPoupanca;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ContaPoupancaTest {

    @Test
    public void testeDepositoContaPoupanca(){
        ContaPoupanca conta = new ContaPoupanca();
        conta.depositar(3000d);

        assertEquals(conta.obterSaldo(),3000);
    }

    @Test
    public void testeSaqueSucessoContaPoupanca(){
        ContaPoupanca conta = new ContaPoupanca();
        conta.depositar(4000d);
        boolean validacao = conta.saque(3000d);

        assertTrue(validacao);
        assertEquals(995, conta.obterSaldo());

    }

    @Test
    public void testeSaqueInvalidoContaPoupanca(){
        ContaPoupanca conta = new ContaPoupanca();
        conta.depositar(3000d);
        boolean validacao = conta.saque(3000d);

        assertFalse(validacao);
        assertEquals(3000, conta.obterSaldo());

    }

}
