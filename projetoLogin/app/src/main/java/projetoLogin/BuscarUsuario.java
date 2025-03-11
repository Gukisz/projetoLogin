package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuscarUsuario {
    // Método para buscar um usuário pelo nome
    public static String[] buscarUsuario(Connection conexao, String nomeUsuario) {
        String[] dadosUsuario = new String[3];
        String sql = "SELECT * FROM usuarios WHERE nome = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dadosUsuario[0] = rs.getString("nome");
                dadosUsuario[1] = rs.getString("senha");
                dadosUsuario[2] = rs.getString("id");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }

        return dadosUsuario;
    }
}