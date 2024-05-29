package br.unipar;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String url = "jdbc:postgresql://localhost:5432/Exemplo1";
    private static final String user = "postgres";
    private static final String password = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        criarTabelaUsuario();

        while (true) {
            System.out.println("Escolha uma operação: [1] Inserir, [2] Listar, [3] Atualizar, [4] Excluir, [5] Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Insira username:");
                    String username = scanner.nextLine();
                    System.out.println("Insira password:");
                    String password = scanner.nextLine();
                    System.out.println("Insira nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Insira data de nascimento (YYYY-MM-DD):");
                    String nascimento = scanner.nextLine();
                    inserirUsuario(username, password, nome, nascimento);
                    break;
                case 2:
                    listarTodosUsuarios();
                    break;
                case 3:
                    System.out.println("Insira o código do usuário a ser atualizado:");
                    int codigoAtualizar = scanner.nextInt();
                    scanner.nextLine();  // Consuming the newline character
                    System.out.println("Insira novo username:");
                    String novoUsername = scanner.nextLine();
                    System.out.println("Insira novo password:");
                    String novoPassword = scanner.nextLine();
                    System.out.println("Insira novo nome:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Insira nova data de nascimento (YYYY-MM-DD):");
                    String novoNascimento = scanner.nextLine();
                    atualizarUsuario(codigoAtualizar, novoUsername, novoPassword, novoNome, novoNascimento);
                    break;
                case 4:
                    System.out.println("Insira o código do usuário a ser excluído:");
                    int codigoExcluir = scanner.nextInt();
                    excluirUsuario(codigoExcluir);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void criarTabelaUsuario() {
        try (Connection conn = connection(); Statement statement = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS usuarios ( " +
                    "codigo SERIAL PRIMARY KEY," +
                    "username VARCHAR(50) UNIQUE NOT NULL," +
                    "password VARCHAR(300) NOT NULL," +
                    "nome VARCHAR(50) NOT NULL," +
                    "nascimento DATE)";
            statement.execute(sql);
            System.out.println("Tabela criada");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void inserirUsuario(String username, String password, String nome, String dataNascimento) {
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "INSERT INTO usuarios (username, password, nome, nascimento) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, Date.valueOf(dataNascimento));
            preparedStatement.executeUpdate();
            System.out.println("Usuario inserido!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void listarTodosUsuarios() {
        try (Connection conn = connection(); Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM usuarios");
            while (result.next()) {
                System.out.println("Código: " + result.getInt("codigo"));
                System.out.println("Username: " + result.getString("username"));
                System.out.println("Nome: " + result.getString("nome"));
                System.out.println("Nascimento: " + result.getDate("nascimento"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void atualizarUsuario(int codigo, String username, String password, String nome, String dataNascimento) {
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "UPDATE usuarios SET username = ?, password = ?, nome = ?, nascimento = ? WHERE codigo = ?")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setDate(4, Date.valueOf(dataNascimento));
            preparedStatement.setInt(5, codigo);
            preparedStatement.executeUpdate();
            System.out.println("Usuario atualizado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void excluirUsuario(int codigo) {
        try (Connection conn = connection();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "DELETE FROM usuarios WHERE codigo = ?")) {

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            System.out.println("Usuario excluído!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

==================
==================

  import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @BeforeAll
    public static void setup() {
        Main.criarTabelaUsuario();
    }

    @Test
    public void testInserirUsuario() {
        Main.inserirUsuario("testuser", "testpass", "Test User", "2000-01-01");
        try (Connection conn = Main.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE username = 'testuser'")) {

            assertTrue(resultSet.next());
            assertEquals("testuser", resultSet.getString("username"));
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAtualizarUsuario() {
        Main.inserirUsuario("updatetest", "pass", "Update Test", "1990-01-01");
        Main.atualizarUsuario(1, "updateduser", "newpass", "Updated Name", "1985-05-05");

        try (Connection conn = Main.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE username = 'updateduser'")) {

            assertTrue(resultSet.next());
            assertEquals("updateduser", resultSet.getString("username"));
            assertEquals("Updated Name", resultSet.getString("nome"));
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testExcluirUsuario() {
        Main.inserirUsuario("deletetest", "pass", "Delete Test", "1990-01-01");
        Main.excluirUsuario(1);

        try (Connection conn = Main.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE username = 'deletetest'")) {

            assertFalse(resultSet.next());
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}
