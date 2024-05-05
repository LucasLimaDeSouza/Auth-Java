package VIEW;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class frmLoginVIEW extends JFrame {
    private JTextField txtNomeUsuario;
    private JTextField txtSenhaUsuario;
    private JButton btnEntrarSistema;
    private JPanel panelMain;

    public static void main(String[] args) {
        frmLoginVIEW h = new frmLoginVIEW();
        h.setContentPane(h.panelMain);
        h.setTitle("Digite os seus dados, meu maneirin!");
        h.setSize(300,400);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public frmLoginVIEW() {
        btnEntrarSistema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Logar();

            }
        });


    }

    private void Logar() {

        try {
            String nome_usuario = txtNomeUsuario.getText();
            String senha_usuario = txtSenhaUsuario.getText();

            UsuarioDTO objusuariodto = new UsuarioDTO();

            objusuariodto.setNome_usuario(nome_usuario);
            objusuariodto.setSenha_usuario(senha_usuario);

            UsuarioDAO objusuariodao = new UsuarioDAO();

            ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);

            if (rsusuariodao.next()) {
                System.out.println("Autenticado com sucesso");

            } else {
                JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INVALIDA");
            }

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "FrmLoginView" + error);
        }
    }

    //    private void createUIComponents() {
//        // TODO: place custom component creation code here
//    }

}
