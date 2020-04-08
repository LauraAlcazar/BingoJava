/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Laura
 */
public class Columna {
    private TreeSet <Integer> numCol; //realizo un treeSet porque es un set de numeros (no se pueden repetir) y estan ordenados porque la clase Integer implementa A COMPARABLE
    private ArrayList <Integer> numerCols=new ArrayList();

    public Columna() {
        numCol=new TreeSet<Integer>();
    }
    public int get(int cual){
        return numerCols.get(cual);
    }//no podemos hacer un get a un set
    public int set(int cual, int num){
        return numerCols.set(cual, num);
    }//idem.
    public void generarCol(int colu){
        //relleno de numeros
        int numAleat1=0;
        int cont=0;
        //genero numeros random en funcion de la columna en la que estemos.
        do{
            numAleat1=(int)(Math.round(Math.random()*9)); // Aleatorio del 0 al 9
            numAleat1 += (colu*10); // Y Sumo la base de la columna (0, 10, 20, 30...)
            if (numAleat1 == 0) {
                // caso especial 0: no existe en el carton, se pasa a 1
                numAleat1 = 1;
            }
            boolean añadido=numCol.add(numAleat1);
            if(añadido==true){
                cont++; 
            }
        }while(cont<3);
        //una vez he realizado el TreeSet de columnas lo convierto a un arrayList para poder acceder a los elementos aleatorios en carton.
        
        numerCols.addAll(numCol);
        /*Iterator <Integer> iter=numCol.iterator();
        while(iter.hasNext()){
            numerCols.add(iter.next());
        }*/
    }
    @Override
    public String toString() {
        String cad="";
        Iterator <Integer> iter=numCol.iterator();
        while(iter.hasNext()){
            cad+="\n"+iter.next();
        }
        return cad;
    }
}
