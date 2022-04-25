/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arust
 */
public class Modelo_Persona extends Persona{
    
     ConexionPG cpg = new ConexionPG();

    public Modelo_Persona() {
    }

    public Modelo_Persona(int id_persona, String nombre, String apellido) {
        super(id_persona, nombre, apellido);
    }

    

    public List<Persona> cargar_datosPersona() {
        List<Persona> lista = new ArrayList<Persona>();
        try {
            String sql = "select * from persona";
            ResultSet rs = cpg.colsulta(sql);
            
            while (rs.next()) {
                Persona pr = new Persona();
                pr.setId_persona(rs.getInt("id_persona"));
                pr.setNombre(rs.getString("nombre"));
                pr.setApellido(rs.getString("apellido"));
                lista.add(pr);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Persona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
