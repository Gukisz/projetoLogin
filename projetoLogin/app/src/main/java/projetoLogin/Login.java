package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    // Método para validar o login do usuário
    public static boolean validarLogin(String usuario, String senha) {
        String sql = "SELECT senha FROM usuarios WHERE nome = ?";

        try (Connection conn = new ConexaoSQLite().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaArmazenada = rs.getString("senha");
                if (senha.equals(senhaArmazenada)) {
                    System.out.println("Login realizado com sucesso!");
                    return true;
                } else {
                    System.out.println("Senha incorreta.");
                }
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
        }

        return false;
    }
}