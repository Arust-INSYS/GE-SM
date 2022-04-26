/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
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

    public Modelo_Empleado(int id_empleado, String cedula, String nombre, String apellido, java.sql.Date fecha_contrato, double salario, String horario, String discapacidad) {
        super(id_empleado, cedula, nombre, apellido, fecha_contrato, salario, horario, discapacidad);
    }

    

    

    

    public List<Empleado> cargar_datosEmpleado() {
        List<Empleado> lista = new ArrayList<Empleado>();
        try {
            String sql = "select * from empleado";
            ResultSet rs = cpg.colsulta(sql);
            
            while (rs.next()) {
                Empleado pr = new Empleado();
                pr.setId_empleado(rs.getInt("id_empleado"));
                pr.setCedula(rs.getString("cedula"));
                pr.setNombre(rs.getString("nombre"));
                pr.setApellido(rs.getString("apellido"));
                pr.setFecha_contrato(rs.getDate("fecha_contrato"));
                pr.setSalario(rs.getDouble("salario"));
                pr.setHorario(rs.getString("horario"));
                pr.setDiscapacidad(rs.getString("discapacidad"));
                lista.add(pr);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Empleado> buscarEmpleados(String texto){
        List<Empleado> lista = new ArrayList<Empleado>();
        ResultSet rs;
        String sql="";
        try {
           
               sql = "SELECT* FROM empleado WHERE UPPER(nombre) LIKE '"+texto+"%' OR "
                       + " UPPER(apellido) LIKE '"+texto+"%'";
           
            
             rs = cpg.colsulta(sql);
            while (rs.next()) {
                Empleado em = new Empleado();
//                ser.setId_servicio(rs.getInt("id_servicio"));
                  em.setId_empleado(rs.getInt("id_empleado"));
                  em.setCedula(rs.getString("cedula"));
                  em.setNombre(rs.getString("nombre"));
                  em.setApellido(rs.getString("apellido"));
                  em.setFecha_contrato(rs.getDate("fecha_contrato"));
                  em.setSalario(rs.getDouble("salario"));                  
                  em.setHorario(rs.getString("horario"));
                  em.setDiscapacidad(rs.getString("discapacidad"));
                lista.add(em);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean crearEmpleado() {
        try {
            String sql;
            sql = "INSERT INTO empleado (cedula, nombre, apellido, salario, horario, discapacidad)";
            sql += "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cpg.getCon().prepareStatement(sql);
            ps.setString(1, getCedula());
            ps.setString(2, getNombre());
            ps.setString(3, getApellido());
            ps.setDouble(4, getSalario());
            ps.setString(5, getHorario());
            ps.setString(6, getDiscapacidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } //en uso
    

     public boolean editarEmpleado(){
        try {
            String sql="";
            sql = "UPDATE empleado SET cedula=?,nombre=?,apellido=?,salario=?,horario=?,discapacidad=? WHERE id_empleado=?";
            PreparedStatement ps = (PreparedStatement) cpg.getCon().prepareStatement(sql);
            
          ps.setString(1, getCedula());          
          ps.setString(2, getNombre());
          ps.setString(3, getApellido());
          ps.setDouble(4,getSalario());
          ps.setString(5, getHorario());
          ps.setString(6, getDiscapacidad());
          ps.setInt(7, getId_empleado());
          ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean eliminar(int id){
        String sql; 
        sql="DELETE FROM empleado WHERE id_empleado='"+id+"'";
                
        
     return cpg.accion(sql);
     }
    
    public List<Discapacidad> comboboxD(){ 
        List<Discapacidad> lista = new ArrayList<Discapacidad>();
        
        try {
            String sql = "select id_discapacidad from discapacidad";
            ResultSet rs = cpg.colsulta(sql);
            
            while (rs.next()) {
                Discapacidad dis = new Discapacidad();
                dis.setId_discapacidad(rs.getString("id_discapacidad"));
                
                lista.add(dis);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    } //en uso
    
    public List<Discapacidad> selecctionD(String id_discp){
         List<Discapacidad> lista = new ArrayList<Discapacidad>();
        try {
           
            String sql = "SELECT id_discapacidad FROM discapacidad WHERE id_discapacidad='"+id_discp+"'";
            
            ResultSet rs = cpg.colsulta(sql);
            while (rs.next()) {
                Discapacidad dis = new Discapacidad();
                dis.setId_discapacidad(rs.getString("id_discapacidad"));
                
                lista.add(dis);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Horario> comboboxHora(){ 
        List<Horario> lista = new ArrayList<Horario>();
        
        try {
            String sql = "select tiempo_trabajo from horario";
            ResultSet rs = cpg.colsulta(sql);
            
            while (rs.next()) {
                Horario hor = new Horario();
                hor.setHorario(rs.getString("tiempo_trabajo"));
                
                lista.add(hor);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    } //en uso
    
    public List<Horario> selecctionHora(String horario){
         List<Horario> lista = new ArrayList<Horario>();
        try {
           
            String sql = "SELECT id_horario FROM horario WHERE tiempo_trabajo='"+horario+"'";
            
            ResultSet rs = cpg.colsulta(sql);
            while (rs.next()) {
                Horario hr = new Horario();
                hr.setId_horario(rs.getString("id_horario"));
                
                lista.add(hr);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
