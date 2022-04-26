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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        vista.getBtnEditar().addActionListener(l->abrirDialogo(2));
        //Dialogo empleado
        llenar_comobobox();
        llenar_comoboboxHR();
        vista.getBtnAceptar().addActionListener(l->crear_editar_Empleado());
        vista.getCbxDiscapacidad().addActionListener(l->seleccion_combo());
        vista.getCbxHorario().addActionListener(l->seleccion_comboHr());
        vista.getBtnEliminar().addActionListener(l->delete());
        keylist_Empleado();    
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
                id,pe.getCedula(),pe.getNombre(), pe.getApellido(),contrato,salario,
                pe.getHorario(),pe.getDiscapacidad()
                
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
    private void borrar_campos(){
        vista.getTxtCedula().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtSalario().setText("");
        vista.getTxtHorario().setText("");
        vista.getTxtDiscapacidad().setText("");
        
    }
    private void abrirDialogo(int ce){
        String title;
        
        if (ce==1){
            title = "Crear nuevo Empleado";
            vista.getDlgEmpleado().setName("Crear");
            atributos_dialogo(title);
        }
        else{
            title="";
            if(seleccion_empleado()){
            title = "Editar Empleado";
            vista.getDlgEmpleado().setName("Editar");
            atributos_dialogo(title);
            }
        }
        
        
        
        
    }
    private void atributos_dialogo(String texto){
        vista.getDlgEmpleado().setLocationRelativeTo(vista);
        vista.getDlgEmpleado().setSize(600, 350);
        vista.getDlgEmpleado().setTitle(texto);
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
                cargar_datos();
                borrar_campos();
                }else{
            
                 JOptionPane.showMessageDialog(vista,"No se pudo crear al Empleado");
                 }
                    }
            
                    
                
            }
            
        }else{ // EDITAR
            
            
                
            
            String cedula=vista.getTxtCedula().getText();
            String nombre=vista.getTxtNombre().getText();
            String apellido=vista.getTxtApellido().getText();
            Double salario=Double.parseDouble(vista.getTxtSalario().getText());
            String horario=vista.getTxtHorario().getText();
            String discapacidad = vista.getTxtDiscapacidad().getText();
            
            Modelo_Empleado persona = new Modelo_Empleado();
            persona.setCedula(cedula);            
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setSalario(salario);
            persona.setHorario(horario);
            persona.setDiscapacidad(discapacidad);
            
            if(persona.editarEmpleado()){
                JOptionPane.showMessageDialog(vista,"Persona Modificada Correctamente");
                
                borrar_campos();
            }else{
            
                 JOptionPane.showMessageDialog(vista,"No se pudo Modificar");
            }
            cargar_datos();
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
       private void keylist_Empleado() {
        KeyListener buscar = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String busqueda = vista.getTxt_buscarEmp().getText().toUpperCase();
                
                buscar_empleado(busqueda);
            }
        };


        vista.getTxt_buscarEmp().addKeyListener(buscar);
    }
    
      public void buscar_empleado(String texto){
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getJtbl_persona().getModel();
        tblModel.setNumRows(0);
        List<Empleado>listapedi= modelo.buscarEmpleados(texto);
        listapedi.stream().forEach(pe->{
            
            String id = Integer.toString(pe.getId_empleado());
            String contrato= pe.getFecha_contrato().toString();
            String salario = Double.toString(pe.getSalario());
                     
                String[] filap={
                id,pe.getCedula(),pe.getNombre(), pe.getApellido(),contrato,salario,
                pe.getHorario(),pe.getDiscapacidad()
                
            };
                tblModel.addRow(filap);
        });
    }
      public void lista_empleados(){
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getJtbl_persona().getModel();
        tblModel.setNumRows(0);
        List<Empleado>listapedi= modelo.cargar_datosEmpleado();
        listapedi.stream().forEach(cl->{
            
            
            
                     
                String[] filap={
                cl.getCedula(),cl.getNombre(),cl.getApellido()
                
            };
                tblModel.addRow(filap);
        });
    }
      
      private boolean seleccion_empleado(){
        
        int fila=vista.getJtbl_persona().getSelectedRow();
        if(fila>=0){
            try {
                DefaultTableModel dm=(DefaultTableModel) vista.getJtbl_persona().getModel();
//                String cedula =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
//                        , 0));
                String cedula =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
                        , 1));
                String nombre =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
                        , 2));
                String apellido =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
                        , 3));
                String salario =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
                        , 5));
                String horario =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
                        , 6));
                String discapacidad =String.valueOf(dm.getValueAt(vista.getJtbl_persona().getSelectedRow()
                        , 7));
                vista.getTxtCedula().setText(cedula);
                vista.getTxtNombre().setText(nombre);
                vista.getTxtApellido().setText(apellido);
                vista.getTxtSalario().setText(salario);
                vista.getTxtHorario().setText(horario);
                vista.getTxtDiscapacidad().setText(discapacidad);
                return true;
            } catch (Exception e) {
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar Fila");
            return false;
        }
        
    }
    
           
    
      
}
