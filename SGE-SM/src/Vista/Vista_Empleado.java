/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Arust
 */
public class Vista_Empleado extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vista_Persona
     */
    public Vista_Empleado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgEmpleado = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxDiscapacidad = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbxHorario = new javax.swing.JComboBox<>();
        txtApellido = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        txtSalario = new javax.swing.JTextField();
        txtHorario = new javax.swing.JTextField();
        txtDiscapacidad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_persona = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txt_buscarEmp = new javax.swing.JTextField();

        dlgEmpleado.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dlgEmpleado.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Cédula:");
        dlgEmpleado.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));
        dlgEmpleado.getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, -1));

        jLabel9.setText("Nombre:");
        dlgEmpleado.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));
        dlgEmpleado.getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 90, -1));

        jLabel11.setText("Apellido:");
        dlgEmpleado.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel12.setText("Salario:");
        dlgEmpleado.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel13.setText("Discapacidad:");
        dlgEmpleado.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        cbxDiscapacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item1" }));
        dlgEmpleado.getContentPane().add(cbxDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 60, -1));

        jLabel14.setText("Horario:");
        dlgEmpleado.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        cbxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dlgEmpleado.getContentPane().add(cbxHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 80, -1));
        dlgEmpleado.getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 90, -1));

        btnAceptar.setText("Aceptar");
        dlgEmpleado.getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));
        dlgEmpleado.getContentPane().add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 90, -1));
        dlgEmpleado.getContentPane().add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 30, -1));
        dlgEmpleado.getContentPane().add(txtDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 40, -1));

        btnCancelar.setText("Cancelar");
        dlgEmpleado.getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbl_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Empleado", "Cedula", "Nombre", "Apellido", "Fecha_Contrato", "Salario", "Horario", "Discapacidad"
            }
        ));
        jScrollPane1.setViewportView(jtbl_persona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 770, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 390));

        btnCrear.setText("Crear");
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnEditar.setText("Editar");
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        btnEliminar.setText("Remover");
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        getContentPane().add(txt_buscarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTable getJtbl_persona() {
        return jtbl_persona;
    }

    public void setJtbl_persona(JTable jtbl_persona) {
        this.jtbl_persona = jtbl_persona;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JComboBox<String> getCbxDiscapacidad() {
        return cbxDiscapacidad;
    }

    public void setCbxDiscapacidad(JComboBox<String> CbxDiscapacidad) {
        this.cbxDiscapacidad = CbxDiscapacidad;
    }

    public JComboBox<String> getCbxHorario() {
        return cbxHorario;
    }

    public void setCbxHorario(JComboBox<String> cbxHorario) {
        this.cbxHorario = cbxHorario;
    }

    public JDialog getDlgEmpleado() {
        return dlgEmpleado;
    }

    public void setDlgEmpleado(JDialog dlgEmpleado) {
        this.dlgEmpleado = dlgEmpleado;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtSalario() {
        return txtSalario;
    }

    public void setTxtSalario(JTextField txtSalario) {
        this.txtSalario = txtSalario;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JTextField getTxtDiscapacidad() {
        return txtDiscapacidad;
    }

    public void setTxtDiscapacidad(JTextField txtDiscapacidad) {
        this.txtDiscapacidad = txtDiscapacidad;
    }

    public JTextField getTxtHorario() {
        return txtHorario;
    }

    public void setTxtHorario(JTextField txtHorario) {
        this.txtHorario = txtHorario;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }
   
    

    public JTextField getTxt_buscarEmp() {
        return txt_buscarEmp;
    }

    public void setTxt_buscarEmp(JTextField txt_buscarEmp) {
        this.txt_buscarEmp = txt_buscarEmp;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxDiscapacidad;
    private javax.swing.JComboBox<String> cbxHorario;
    private javax.swing.JDialog dlgEmpleado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbl_persona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDiscapacidad;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txt_buscarEmp;
    // End of variables declaration//GEN-END:variables
}
