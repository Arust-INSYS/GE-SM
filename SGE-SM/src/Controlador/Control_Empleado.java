/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionPG;
import Modelo.Discapacidad;
import Modelo.Modelo_Empleado;
import Modelo.Empleado;
import Modelo.Horario;
import Vista.Vista_Empleado;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
        //Dialogo empleado
        llenar_comobobox();
        llenar_comoboboxHR();
        vista.getBtnAceptar().addActionListener(l->crear_editar_Empleado());
        vista.getCbxDiscapacidad().addActionListener(l->seleccion_combo());
        vista.getCbxHorario().addActionListener(l->seleccion_comboHr());
        vista.getBtnEliminar().addActionListener(l->delete());
        
        
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
    
    private void llenar_comobobox(){
        
        JComboBox serlist;
        serlist=vista.getCbxDiscapacidad();
        serlist.removeAllItems();
        List<Discapacidad>listaser= modelo.comboboxD();
//        Holder<Integer>  i = new Holder<>(1);
        listaser.stream().forEach(lista->{
            String id_dis = lista.getId_discapacidad();
            serlist.addItem(id_dis);
//            serlist.addItem(i.value+"."+nom_servicios);
//        i.value++;
            
        });
    }
//    private String id_discapacidad;
    private void seleccion_combo(){
        String discapacidad = (String) vista.getCbxDiscapacidad().getSelectedItem();
        
        List<Discapacidad>lista_sr= modelo.selecctionD(discapacidad);
        lista_sr.stream().forEach(lista->{
            String id_sr = lista.getId_discapacidad();
            vista.getTxtDiscapacidad().setText(id_sr);
            
        });
//        id_discapacidad=discapacidad;
        System.out.println(discapacidad);
//        return id_discapacidad;
    }
    
    ///HORARIO
    private void llenar_comoboboxHR(){
        
        JComboBox serlist;
        serlist=vista.getCbxHorario();
        serlist.removeAllItems();
        List<Horario>listaser= modelo.comboboxHora();
//        Holder<Integer>  i = new Holder<>(1);
        listaser.stream().forEach(lista->{
            String horario = lista.getHorario();
            serlist.addItem(horario);
//            serlist.addItem(i.value+"."+nom_servicios);
//        i.value++;
            
        });
    }
    
    private void seleccion_comboHr(){
        String horario = (String) vista.getCbxHorario().getSelectedItem();
        
        List<Horario>lista_sr= modelo.selecctionHora(horario);
        lista_sr.stream().forEach(lista->{
            String id_sr = lista.getId_horario();
            vista.getTxtHorario().setText(id_sr);
        });
        System.out.println(horario);
    }
    
    private void abrirDialogo(int ce){
        String title;
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        if (ce==1){
            title = "Crear nuevo Empleado";
            vista.getDlgEmpleado().setName("Crear");
        }
        else{
            title = "Editar Empleado";
            vista.getDlgEmpleado().setName("Editar");
        }
        vista.getDlgEmpleado().setLocationRelativeTo(vista);
        vista.getDlgEmpleado().setSize(600, 350);
        vista.getDlgEmpleado().setTitle(title);
        vista.getDlgEmpleado().setVisible(true);
        
        
        
    }
     private void crear_editar_Empleado(){
        
        if(vista.getDlgEmpleado().getName()=="Crear"){
            //INSERTAR
            String cedula=vista.getTxtCedula().getText();
            String nombre=vista.getTxtNombre().getText();
            String apellido=vista.getTxtApellido().getText();
            System.out.println("Holaaa");

            Double salario=Double.parseDouble(vista.getTxtSalario().getText());
//            Instant instant= vista.getDateCh_fechanac().getDate().toInstant();
//            ZoneId zid= ZoneId.of("America/Guayaquil");
//            ZonedDateTime zdt=ZonedDateTime.ofInstant(instant, zid);  
//            java.sql.Date fecha = java.sql.Date.valueOf(zdt.toLocalDate());

             
//             System.out.println(salario);
            String horario = vista.getTxtHorario().getText();
            String discapacidad = vista.getTxtDiscapacidad().getText();
                      
            
            Modelo_Empleado emp = new Modelo_Empleado();
            emp.setCedula(cedula);
            emp.setNombre(nombre);
            emp.setApellido(apellido);            
            emp.setSalario(salario);
            emp.setHorario(horario);              
            emp.setDiscapacidad(discapacidad);
            System.out.println("Si cargó");
            if(cedula.equals("")||nombre.equals("")||apellido.equals("")||
                    horario.equals("")||discapacidad.equals("")){
                JOptionPane.showMessageDialog(vista,"Faltan campos, verifique");
            }else{
                
                    if(salario<=0||salario<450){
                        JOptionPane.showMessageDialog(vista,"Salario no permite valores menor o igual"
                                + "a cero, ingrese un USD de 450 en adelante, verifique");
                    }else{
                        if(emp.crearEmpleado()){
                JOptionPane.showMessageDialog(vista,"Empleado Creado Correctamente");
                }else{
            
                 JOptionPane.showMessageDialog(vista,"No se pudo crear al Empleado");
                 }
                    }
            cargar_datos();
                    
                
            }
            
        }else{ // EDITAR
            
            
            String cedula=vista.getTxtCedula().getText();
            String nombre=vista.getTxtNombre().getText();
            String apellido=vista.getTxtApellido().getText();
            
            Modelo_Empleado persona = new Modelo_Empleado();
            persona.setCedula(cedula);            
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            if(persona.editarEmpleado()){
                JOptionPane.showMessageDialog(vista,"Persona Modificada Correctamente");
            }else{
            
                 JOptionPane.showMessageDialog(vista,"No se pudo Modificar");
            }
            
        }
        
        
    }
      public void delete(){
        DefaultTableModel tablamodel;
        tablamodel = (DefaultTableModel) vista.getJtbl_persona().getModel();
        List<Empleado> per = modelo.cargar_datosEmpleado();
        int elima = vista.getJtbl_persona().getSelectedRow();
        if (elima >= 0) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar  ? \n     " + per.get(elima).getNombre(), "Eliminar", JOptionPane.YES_NO_OPTION);

            if (pregunta == 0) {
                tablamodel.removeRow(elima);
                
                modelo.eliminar(per.get(elima).getId_empleado());
//                cargar_datos();
            } 

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione en la tabla el dato a Eliminar");
        }
        
    }
      
}
