/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Grupo-6K
 * @version
 */
public class ModeloBingo {
    //metodos necesarios para comunicarse con el controlador
    //1.cuando le demos al boton jugar:
    //1.1 ponemos los cartones
    //1.2 sacamos el primero numero del bombo y lo mostramos en la casilla del numero
    //1.3 tachamos ese numero en el carton del bingo y en los cartones
    //1.4 actualizamos las casillas de ganador bingo y ganador linea si hay ganadores.
    //creamos un bombo

    private HashSet<Carton> cartonesBingo = new HashSet();
    private ArrayList<Jugador> jugadores = new ArrayList();
    private Bombo bombo = new Bombo();
    private Carton carton1 = new Carton("carton1");
    private Carton carton2 = new Carton("carton2");
    public boolean comprobarGanadorBingo;
    private boolean hanCantLin = false;
    

    //cuando pulsemos el boton jugar
    public void llenarBombo() {
        bombo.llenar();
    }
    //metodo para devolver la matriz bombo al que le tendre que hacer un toString

    public void crearCartones() {
        carton1.generarCarton();
        carton2.generarCarton();

        cartonesBingo.add(carton1);
        cartonesBingo.add(carton2);
    }

    public int[][] contenidoCarton1() {
        return carton1.toStringInterface();
    }

    public int[][] contenidoCarton2() {
        return carton2.toStringInterface();
    }

    //debemos crear lo jugadores con los nombre de las jlabel
    public void crearJugadores(String nom1, String nom2) {

        Jugador jugador1 = new Jugador(nom1, 1);
        //le asignamos un carton.
        jugador1.ponerCarton(carton1);
        Jugador jugador2 = new Jugador(nom2, 1);
        jugador2.ponerCarton(carton2);

        //añado al array para que no se puedan repetir
        jugadores.add(jugador2);
        jugadores.add(jugador1);

    }
    
    public String GetNombreJugador(int indx){
        //entro en el array de jugadores y devuelvo el nombre
        return jugadores.get(indx).toString();
    }

    //este metodo devemos realizarlo cada vez que saquemos numero
    public void removerBombo() {
        bombo.remover();
    }

    //cada vez que le demos al boton siguiente debemos emplear este metodo
    public int sacarNumero() throws Exception {
        removerBombo();
        int num = -1;
            num = bombo.sacar(); //sacamos el numero
        return num;
    }

    public enum Premios { NADA , LINEA , BINGO}
    
    public Premios[] comprobarPremios(int num)  {   // devolvera un array con cada jugador sus cartones un valor que indica si gano linea (1) o bingo (2) o nada (0).
        // genero un vector de resultados para cada jugador (solo quiero saber quien gana)
        int numjugadores = jugadores.size();
        Premios[] results = new Premios[numjugadores];
        for (int j = 0; j < numjugadores; j++) {
            results[j] =  Premios.NADA;   // inicio a ningun premio 
        }           
        
        Carton cartonActual = null;
        boolean alguienCantoLinea = false;
        Iterator<Carton> iter = cartonesBingo.iterator();
        while (iter.hasNext()) {//compruebo todos los cartones que hay en la partida (varios pueden cantar a la vez).
            try {
                cartonActual = iter.next();
                cartonActual.comprobarCarton(num);//comprobamos si el numero esta en el cartón. si esta lo tachara interanamente
                //comprobara si quedan numeros en la linea y en el carton
            } catch (LineaExcepcion linea) {//salta la excepcion si no hay num en la linea
                if (hanCantLin == false) {// de cualquir ronda anterior
                    for (int j = 0; j < jugadores.size(); j++) {
                        if (jugadores.get(j).tieneCarton(cartonActual)) {
                            results[j] = Premios.LINEA;
                            
                        }
                    }
                    alguienCantoLinea = true; //de esta ronda
                }
            } catch (BingoExcepcion ex) {
                for (int j = 0; j < jugadores.size(); j++) {
                    if (jugadores.get(j).tieneCarton(cartonActual)) {
                        results[j] = Premios.BINGO;
                    }
                }    
            } 
        }
        // ahora bloqueo que se canten mas lineas en otras rondas
        if (alguienCantoLinea) {
            hanCantLin = true;//ya hemos cantado linea
        }
        return results;
    }
    
}
