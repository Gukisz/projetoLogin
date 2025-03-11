package projetoLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {
    // Método para conectar ao banco de dados SQLite
    public Connection conectar() {
        Connection conexao = null;
        String url = "jdbc:sqlite:usuariosNovo.db"; // Caminho do banco de dados

        try {
            // Carrega o driver do SQLite
            Class.forName("org.sqlite.JDBC");
            // Estabelece a conexão
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecida!");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver do SQLite: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return conexao;
    }

    // Método para fechar a conexão com o banco de dados
    public void desconectar(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}