/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arust
 */
public class ConexionPG {
       Connection con;

    String cadConexion = "jdbc:postgresql://ec2-3-218-171-44.compute-1.amazonaws.com:5432/d4sqe0qdp9uds9";
    String pgUser = "essotlrkdcygen";
    String pgPass = "f65f5f86258a595d32097126923414846c3cb725bd0c1c45bdd757525f63c17d";

    public ConexionPG() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(cadConexion, pgUser, pgPass);
            System.out.println("Conexion OK.");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet colsulta(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean accion(String sql){
        boolean correcto = true;
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            correcto = false;
        }
        return correcto;
    }

   
    public Connection getCon() {
        return con;
    }
}
