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
public class Modelo_Empleado extends Empleado{
    
     ConexionPG cpg = new ConexionPG();

    public Modelo_Empleado() {
    }

    public Modelo_Empleado(int id_persona, String nombre, String apellido) {
        super(id_persona, nombre, apellido);
    }

    

    public List<Empleado> cargar_datosEmpleado() {
        List<Empleado> lista = new ArrayList<Empleado>();
        try {
            String sql = "select * from empleado";
            ResultSet rs = cpg.colsulta(sql);
            
            while (rs.next()) {
                Empleado pr = new Empleado();
                pr.setId_empleado(rs.getInt("id_empleado"));
                pr.setNombre(rs.getString("nombre"));
                pr.setApellido(rs.getString("apellido"));
                lista.add(pr);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
