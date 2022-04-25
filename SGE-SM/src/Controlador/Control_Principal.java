/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Persona;
import Vista.Vista_Empleado;
import Vista.Vista_Principal;

/**
 *
 * @author Arust
 */
public class Control_Principal {
    Vista_Principal vista_menu;
    
    public Control_Principal(Vista_Principal vista_menu){
        this.vista_menu=vista_menu;
        vista_menu.setVisible(true);
        vista_menu.setLocationRelativeTo(null);
    }
    public void inicioControl(){
        vista_menu.getBtnPersona().addActionListener(l->Crud_Personas());
    }
    
    private void Crud_Personas(){
        Modelo_Persona modelo= new  Modelo_Persona();
        Vista_Empleado vista = new Vista_Empleado();
        vista_menu.getDkp_principal().add(vista);
        Control_Persona control = new Control_Persona(modelo, vista);
        control.incioControl();
    }
}
