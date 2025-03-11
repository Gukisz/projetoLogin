package projetoLogin;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        Connection conexao = conexaoSQLite.conectar();

        if (conexao != null) {
            CriarTabela.criarTabelaUsuarios(conexao);
            InserirUsuario.inserirUsuario(conexao, "admin", "1234");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}