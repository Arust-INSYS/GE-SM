/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Empleado;
import Modelo.Empleado;
import Vista.Vista_Empleado;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arust
 */
public class Control_Empleado {
    private Modelo_Empleado modelo;
    private Vista_Empleado vista;
    DefaultTableModel modelo_tabla;
    

    public Control_Empleado(Modelo_Empleado modelo, Vista_Empleado vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        
    }
    
    
    public void incioControl(){
        cargar_datos();
        vista.getBtnCrear().addActionListener(l->abrirDialogo(1));
    }
    public void cargar_datos(){
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getJtbl_persona().getModel();
        tblModel.setNumRows(0);
        
        List<Empleado>listap= modelo.cargar_datosEmpleado();
        listap.stream().forEach(pe->{
            String id = Integer.toString(pe.getId_empleado());
            String contrato= pe.getFecha_contrato().toString();
            String salario = Double.toString(pe.getSalario());
            String[] filap={
                id,pe.getCedula(),pe.getNombre(), pe.getApellido(),contrato,salario
                
            };
                tblModel.addRow(filap);
        });
        
    }
    
    private void abrirDialogo(int ce){
        String title;
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        if (ce==1){
            title = "Crear nueva Persona";
            vista.getDlgEmpleado().setName("Crear");
        }
        else{
            title = "Editar Persona";
            vista.getDlgEmpleado().setName("Editar");
        }
        vista.getDlgEmpleado().setLocationRelativeTo(vista);
        vista.getDlgEmpleado().setSize(600, 350);
        vista.getDlgEmpleado().setTitle(title);
        vista.getDlgEmpleado().setVisible(true);
        
        
        
    }
}
