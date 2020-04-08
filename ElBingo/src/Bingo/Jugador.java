/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Grupo-6K
 */
public class Jugador {
    private String nombre;
    private Set<Carton>cart;//tiene un vector de cartones, podria ser un set para que no se repitan.
    private int numCart;//numero de cartones que tiene el jugador

    public Jugador(String nombre,int numCart) {
        this.nombre = nombre;
        cart = new HashSet<Carton>(numCart);
        this.numCart = numCart;
    }
    public void ponerCarton(Carton e){
        cart.add(e);
    }
    public int getNumCartones(){
        return cart.size();
    }
    public boolean tieneCarton(Carton cual){
        boolean res= cart.contains(cual);
        return res;
    }
    @Override
    public String toString() {
        return nombre;
    }
}
