/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execute;

import Controlador.Control_Principal;
import Vista.Vista_Principal;

/**
 *
 * @author Arust
 */
public class Execute {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vista_Principal vista = new Vista_Principal();
        Control_Principal control = new Control_Principal(vista);
        control.inicioControl();
    }
    
}
