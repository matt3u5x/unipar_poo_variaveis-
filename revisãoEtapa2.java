 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação de objeto (Produto) com o 1º construtor;
        Produto produto1 = new Produto("Produto A");
        System.out.println("Produto 1:");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Preço: " + produto1.getPreco());
        System.out.println("Quantidade em estoque: " + produto1.getQuantEstoque());
        System.out.println(" ");

        // Criação de objeto (Produto) com o 2º construtor;

        System.out.print("Digite o nome do Produto B: ");
        String nomeProdutoB = scanner.nextLine();
        System.out.print("Digite o preço do Produto B: ");
@@ -478,8 +475,6 @@ public static void main(String[] args) {
        System.out.println("Quantidade em estoque: " + produto2.getQuantEstoque());
        System.out.println();

        // Criação de obejto (Produto) com o 3º construtor;

        System.out.print("Digite o nome do Produto C: ");
        scanner.nextLine();
        String nomeProdutoC = scanner.next();
