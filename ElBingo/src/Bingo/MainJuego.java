/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo-6K
 */
public class MainJuego {
    public static void main(String[] args) {
        //creamos un bombo
        HashSet <Carton> cartonesBingo=new HashSet();
        ArrayList <Jugador> jugadores=new ArrayList();
        Bombo bombo=new Bombo();
        //lo llenamos
        bombo.llenar();
        //creamos un carton
        Carton carton1=new Carton("carton1");
        Carton carton2=new Carton("carton2");
        Carton carton3=new Carton("carton3");
        //lo generamos
        carton1.generarCarton();
        carton2.generarCarton();
        carton3.generarCarton();
        //lo imprimimos
        System.out.println("LOS CARTONES DE LA PARTIDA SON:");
        System.out.println("el carton 1");
        System.out.println(carton1);
        System.out.println("el carton 2");
        System.out.println(carton2);
        System.out.println("el carton 3");
        System.out.println(carton3);
        
        //creamos un jugador dandole un nombre y un numero de cartones
        Jugador jugador1= new Jugador("Juan", 1);
        //le asignamos un carton.
        jugador1.ponerCarton(carton1);
        Jugador jugador2= new Jugador("Maria", 1);
        jugador2.ponerCarton(carton2);
        Jugador jugador3= new Jugador("Laura", 1);
        jugador3.ponerCarton(carton3);
        jugadores.add(jugador3);
        jugadores.add(jugador2);
        jugadores.add(jugador1);
        
        cartonesBingo.add(carton1);
        cartonesBingo.add(carton2);
        cartonesBingo.add(carton3);
        
        //comenzamos el juego.
        System.out.println("¡VAMOS A JUGAR AL BINGO!");
        boolean res=false;
        boolean hanCantLin=false;
        Carton cartonActual=null;
        do{
            bombo.remover();//remosvemos el bombo
            int num=-1;
            try {
                num = bombo.sacar(); //sacamos el numero
            } catch (Exception ex) {
                Logger.getLogger(MainJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("el numero es: "+num); //lo imprimimos.
            boolean alguienCantoLinea =false;
            Iterator <Carton> iter=cartonesBingo.iterator();
            while(iter.hasNext()) {//compruebo todos los cartones que hay en la partida (varios pueden cantar a la vez).
                try{
                    cartonActual=iter.next();
                    cartonActual.comprobarCarton(num);//comprobamos si el numero esta en el cartón. si esta lo tachara interanamente
                    //comprobara si quedan numeros en la linea y en el carton
                }catch(LineaExcepcion linea){//salta la excepcion si no hay num en la linea
                    if(hanCantLin==false){  // de cualquir ronda anterior
                       System.out.println(linea.getMessage());
                       System.out.println("¡Ha ganado el jugador:!");
                    for (int j = 0; j < jugadores.size(); j++) {
                        if(jugadores.get(j).tieneCarton(cartonActual)){
                            System.out.println(jugadores.get(j)+" con el carton: " + cartonActual.getNombre());
                        }
                    }
                       alguienCantoLinea=true; //de esta ronda
                    }
                }catch(BingoExcepcion bingo){ //salata excepcion si no hay num en el cartón.
                    res=true; //fin del juego.
                    System.out.println(bingo.getMessage());
                    System.out.println("FIN JUEGO");
                    System.out.println("¡Ha ganado el jugador:!");
                    for (int j = 0; j < jugadores.size(); j++) {
                        if(jugadores.get(j).tieneCarton(cartonActual)){
                            System.out.println(jugadores.get(j)+" con el carton: " + cartonActual.getNombre());
                        }
                    }
                }
            }
            // ahora bloqueo que se canten mas lineas en otras rondas
            if (alguienCantoLinea)
            {
                 hanCantLin=true;//ya hemos cantado linea
            }
        }while(res==false);//acabara cuando ya no haya numeros en el carton 
    }
}
