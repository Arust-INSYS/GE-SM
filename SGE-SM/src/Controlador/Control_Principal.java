/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionPG;
import Modelo.Modelo_Empleado;
import Vista.Vista_Empleado;
import Vista.Vista_Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
        vista_menu.getBtnPersona().addActionListener(l->Crud_Empleado());
        //Reportes
        vista_menu.getMitmRpsEmpleado().addActionListener(l->Imprimir_empleado());
    }
    
    private void Crud_Empleado(){
        Modelo_Empleado modelo= new  Modelo_Empleado();
        Vista_Empleado vista = new Vista_Empleado();
        vista_menu.getDkp_principal().add(vista);
        Control_Empleado control = new Control_Empleado(modelo, vista);
        control.incioControl();
    }
    private void Imprimir_empleado(){
        ConexionPG connection = new ConexionPG();
        try {
            JasperReport jr=(JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Reporte_Empleados_A4.jasper"));
        
            Map<String,Object> parametro = new HashMap<String,Object>();
//            parametro.put("limite_sueldo", 500.0);
//            parametro.put("sueldo_menos", 2000.0);
//            parametro.put("genero", "M");
            
            JasperPrint jp= JasperFillManager.fillReport(jr,parametro, connection.getCon());
            
            JasperViewer jv = new JasperViewer(jp);
            
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Control_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
