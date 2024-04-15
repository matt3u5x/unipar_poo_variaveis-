package Objetos;

public class Produto {
    private final int codigo;
    private final String descricao;
    private final double preco;
    private int quantidadeEmEstoque;

    public Produto(int codigo, String descricao, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Método para adicionar estoque
    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
    }

    // Método para remover estoque
    public void removerEstoque(int quantidade) {
        if (quantidadeEmEstoque >= quantidade) {
            quantidadeEmEstoque -= quantidade;
        } else {
            System.out.println("Erro: Estoque insuficiente para remover essa quantidade.");
        }
    }
}

package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar;

        Produto produto = new Produto(1, "Notebook Lenovo, Intel i5 10th, GTX 1650.", 4950.99, 50);

        do {
            System.out.println(" ");
            System.out.println("Opções:");
            System.out.println("1 - Consultar Produto");
            System.out.println("2 - Adicionar Produto ao Estoque");
            System.out.println("3 - Remover Produto do Estoque");
            System.out.println(" ");
            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println(" ");
                System.out.println("PRODUTO:");
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Preço: " + produto.getPreco());
                System.out.println("Quantidade em Estoque: " + produto.getQuantidadeEmEstoque());
                System.out.println(" ");
            }

            if (opcao == 2) {
                System.out.print("Digite a quantidade a ser adicionada ao estoque: ");
                int quantidade = scanner.nextInt();
                produto.adicionarEstoque(quantidade);
                System.out.println("Estoque atualizado. Quantidade em estoque agora: " + produto.getQuantidadeEmEstoque());
                System.out.println(" ");

            }

            if (opcao == 3) {
                System.out.print("Digite a quantidade a ser removida do estoque: ");
                int quantidade = scanner.nextInt();
                produto.removerEstoque(quantidade);
                System.out.println("Estoque atualizado. Quantidade em estoque agora: " + produto.getQuantidadeEmEstoque());
                System.out.println(" ");

            }

            System.out.println("Deseja continuar? s/n");
            continuar = scanner.next().charAt(0);

        } while (continuar == 's' || continuar == 'S');
        System.out.println(" ");
        System.out.println(" ---------------------");
        System.out.println("| PROGRAMA ENCERRADO  |");
        System.out.println(" ---------------------");
    }
}
