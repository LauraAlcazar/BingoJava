/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Grupo-6K
 */
public class Bombo {
    private ArrayList<Integer>numBombo;
    //tachar elementos y tachar filas.

    public Bombo() {
        numBombo = new ArrayList<Integer>();
    }
    //llenamos el bombo con numeros del 1 al 99. no se pueden repetir
    public void llenar(){
        for (int i = 1; i < 90; i++) {
            numBombo.add(i);
        }
    }
    //removemos el bombo
    public void remover(){
        Collections.shuffle(numBombo);
    }
    //sacamos del bombo. devuelve un int que imprimiremos por pantalla.
    public int sacar() throws Exception{
        //debe sacar los numeros del bombo aleatoriamente. el metodo remove devuelve el elemento que se encuetra en la posicion a remover
        //hay 89 numeros en el bombo, por lo que hay 89 posiciones en el array
        if(numBombo.size()>0){
             return numBombo.remove(0); //el remove disminuye el tamaño del array
        }else{
            throw new Exception("bombo vacio");
        }
    }
}
