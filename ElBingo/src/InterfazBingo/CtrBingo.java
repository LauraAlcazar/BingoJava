/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazBingo;

import Bingo.ModeloBingo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Laura
 */
public class CtrBingo implements ActionListener {

    private VistaBingo vista;
    private ModeloBingo modelo;
    private boolean finjuego = false;
    //poner modelo

    //falta pasarle el modelo
    public CtrBingo(VistaBingo vista, ModeloBingo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Jugar")) {
            //cambio panel bingo por lo que la vista me debe dar el contenido del panel cartonBingo
            //cambio los paneles de los jugadores
            vista.setEnabledJugar();
            vista.setEnabledSiguiente();
            modelo.crearCartones();
            modelo.llenarBombo();
            vista.setContentCartonJugador1(modelo.contenidoCarton1());
            vista.setContentCartonJugador2(modelo.contenidoCarton2());
            modelo.crearJugadores(vista.getNomjugador1(), vista.getNomjugador2());
        }
        if (comando.equals("Siguiente")) {
            if (finjuego == false) {
                modelo.removerBombo();
                int num=0;
                try {
                    num = modelo.sacarNumero();
                } catch (Exception ex) {
                    //me debe saltar tmb la excepcion de que se ha acabado el bombo para poner fin en el panel
                }
                vista.setContentTextSiguiente(num);
                vista.setContentCartonBingo(num);
                //premios es un array de enums que esta declarado dentro del modelo
                ModeloBingo.Premios[] premiosJugador = modelo.comprobarPremios(num);

                vista.setContentCartonJugador1(modelo.contenidoCarton1());
                vista.setContentCartonJugador2(modelo.contenidoCarton2());

                // Verificar resultado premios
                String ganadores = "";
                for (int i = 0; i < premiosJugador.length; i++) {
                    if (premiosJugador[i] == ModeloBingo.Premios.BINGO){
                        //si hay premio bingo en erray de enums devuelvo los nombres de todos los ganadores
                        ganadores += modelo.GetNombreJugador(i)+" ";            
                    }
                }
                if (ganadores != "") {
                    //si hay ganadores los pongo en el jtextfield
                    vista.setTextFieldGanadorBingo(ganadores);
                    finjuego = true;
                }
                else{
                    //los mismo para los premiso de linea
                    for (int i = 0; i < premiosJugador.length; i++) {
                        if (premiosJugador[i] == ModeloBingo.Premios.LINEA){
                            ganadores += modelo.GetNombreJugador(i)+" ";            
                        }
                        if (ganadores != "") {
                            vista.setTextFieldGanadorLinea(ganadores);
                        }
                    }

                }
            }
        }
        
    }//fin action

}//fin clase


