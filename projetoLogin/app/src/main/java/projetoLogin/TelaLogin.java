package projetoLogin;

import javax.swing.JOptionPane;
import java.sql.Connection;

public class TelaLogin extends javax.swing.JFrame {

    private ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
    private Connection conexao = conexaoSQLite.conectar();

    public TelaLogin() {
        initComponents();
        if (conexao != null) {
            CriarTabela.criarTabelaUsuarios(conexao);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        senha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoLogin = new javax.swing.JButton();
        botaoRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuario.setText("Usuário");

        senha.setText("Senha");

        botaoLogin.setText("Login");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        botaoRegistrar.setText("Registrar");
        botaoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senha, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoUsuario)
                    .addComponent(campoSenha)
                    .addComponent(botaoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoRegistrar)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        if (Login.validarLogin(usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            String[] user = BuscarUsuario.buscarUsuario(conexao, usuario);
            new TelaUsuario(user[0], user[1], user[2]).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void botaoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarActionPerformed
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        if (InserirUsuario.inserirUsuario(conexao, usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao registrar usuário.");
        }
    }//GEN-LAST:event_botaoRegistrarActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoRegistrar;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}