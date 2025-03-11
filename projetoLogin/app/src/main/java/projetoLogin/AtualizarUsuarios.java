package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AtualizarUsuarios {
    // Método para atualizar um usuário no banco de dados
    public static void atualizarUsuarios(Connection conexao, int id, String novoNome, String novaSenha) {
        String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE id = ?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, novoNome);
            pstmt.setString(2, novaSenha);
            pstmt.setInt(3, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID fornecido.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }
}