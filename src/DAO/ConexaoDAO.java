package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    public Connection conectaDB() {

        Connection conn = null;

        try {

            String url = "jdbc:mysql://localhost:3306/bancoteste?useSSL=false&user=root&password=password";

            conn = DriverManager.getConnection(url);

        }catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }

        return conn;

    }

}



