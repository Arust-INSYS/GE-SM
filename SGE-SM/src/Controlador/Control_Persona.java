/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Persona;
import Modelo.Persona;
import Vista.Vista_Empleado;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arust
 */
public class Control_Persona {
    private Modelo_Persona modelo;
    private Vista_Empleado vista;
    DefaultTableModel modelo_tabla;
    

    public Control_Persona(Modelo_Persona modelo, Vista_Empleado vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        
    }
    
    
    public void incioControl(){
        cargar_datos();
    }
    public void cargar_datos(){
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getJtbl_persona().getModel();
        tblModel.setNumRows(0);
        List<Persona>listap= modelo.cargar_datosPersona();
        listap.stream().forEach(pe->{
            String id = Integer.toString(pe.getId_persona());
            String[] filap={
                id,pe.getNombre(), pe.getApellido()
                
            };
                tblModel.addRow(filap);
        });
    }
}
