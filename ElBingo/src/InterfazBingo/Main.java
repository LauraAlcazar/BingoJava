/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBingo;

import Bingo.ModeloBingo;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Laura
 */
public class Main {
    public static void main(String[] args) {
        ModeloBingo modelo= new ModeloBingo();
        VistaBingo vista=new PanelBingo();
        //faltara pasarle el modelo y cambiarlo de nombre
        ActionListener ctr = new CtrBingo(vista, modelo);
        vista.controlador(ctr);

        JFrame ventana = new JFrame("El Bingo");
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setContentPane((JPanel) vista);
        ventana.setSize(1300,650);
	//ventana.pack();
	ventana.setVisible(true);
    }
}
