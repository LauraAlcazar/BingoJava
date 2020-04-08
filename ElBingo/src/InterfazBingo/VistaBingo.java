/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBingo;

import java.awt.event.ActionListener;

/**
 *
 * @author Laura
 */
public interface VistaBingo {
    void controlador(ActionListener ctr);
    public void setContentCartonBingo(int contenidoCarton1);
    public void setContentCartonJugador1(int[][] contenidoCarton1);
    public void setContentCartonJugador2(int[][] contenidoCarton2);
    public String getNomjugador1();
    public String getNomjugador2();
    public void setTextFieldGanadorBingo(String nomGanador);
    public void setTextFieldGanadorLinea(String nomGanador);
    public void setContentTextSiguiente(int contenidoCarton1);
    public void setEnabledSiguiente();
    public void setEnabledJugar();
}
