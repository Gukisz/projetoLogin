package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InserirUsuario {
    // Método para inserir um usuário no banco de dados
    public static boolean inserirUsuario(Connection conexao, String nome, String senha) {
        String sqlCheck = "SELECT * FROM usuarios WHERE nome = ?";
        String sqlInsert = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

        try (PreparedStatement checkStmt = conexao.prepareStatement(sqlCheck)) {
            checkStmt.setString(1, nome);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Usuário já existe no banco de dados.");
                return false;
            }

            try (PreparedStatement insertStmt = conexao.prepareStatement(sqlInsert)) {
                insertStmt.setString(1, nome);
                insertStmt.setString(2, senha);
                insertStmt.executeUpdate();
                System.out.println("Usuário inserido com sucesso!");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            return false;
        }
    }
}