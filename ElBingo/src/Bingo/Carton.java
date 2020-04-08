/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
    //carton 3*9 y en cada linea hay 5 numeros //15 numeros en total
    //cantar linea
    //cantar bingo
    //columnas de 1-10; 11-20; 21-30; 31-40; 41-50; 51-60; 61-70; 71-80; 81-90; cada col tendra uno o dos numeros
    //las columnas pueden estar vacias o llenas totalmente
    //posiciones aleatorias del 0 al 2
    //si una posicion esta vacia ponemos numeros.
public class Carton{
    private String nombre;
    private ArrayList <Columna> colsCart; 
    
    public Carton(String nombre){
        this.nombre=nombre;
        colsCart= new ArrayList<Columna>(9);
    }

    public String getNombre() {
        return nombre;
    }
    public void generarCarton(){
        for (int i = 0; i < 9; i++) {//relleno cada linea del carton con columnas
            Columna col=new Columna(); //creamos 9 columnas
            col.generarCol(i); //generamos las columnas
            colsCart.add(col); //las añadimos al arrayList de columnas.
        }
        //hacer los huecos con 0.//cuatro huecos random para cada fila (pueden haber mas de dos consecutivos).
        //preselec de 4 numeros (cuatro indices de columnas) .
        
        for (int fila = 0; fila < 3; fila++) {
            int [] huecos= {0, 0, 0, 0}; //cada fila 4 huecos.
            int cont=0;
            do{
                int aleat=(int)(Math.random()*8); //genero un numero aleatorio entre 0 y 8
                boolean repe = false;
                for (int k = 0; k < huecos.length; k++){
                    if (aleat == huecos[k]){//recorro el vector de huecos y compruebo que ese num aleatorio no esta
                        repe = true;
                    }
                }
                if (repe == false){//si el numAleatorio no esta repe se lo asigno al vector.
                    huecos[cont]=aleat;//vector de huecos que contiene los numeros aleatorios de las posiciones donde situaré los huecos.
                    cont++;
                }
            }while(cont<4);//hasta tener cuatro
            // asignamos los huecos en la fila actual.
            for (int i = 0; i < huecos.length; i++) {
                //dame la columna de la posición huecos[i] que es un numero aleatorio  y pone un hueco (0) en la fila (fija para cada iteración)
                //debemos acceder a elementos del treeSet aleatoriamente por lo que deberemos comverir el treeSet en un ArrayList.(en columna)
                colsCart.get(huecos[i]).set(fila, 0); //0 = hueco
            }
        }
    }
    public void comprobarCarton(int num) throws BingoExcepcion, LineaExcepcion{ //esto lo mismo seria mejor hacerlo con indexOf
        //comprobamos si el numero esta en el carton
        for (int i = 0; i < 9; i++) {//recorro las filas (9)
            //accedo a los elementos de cada fila
            for (int j = 0; j < 3; j++) {
                if(colsCart.get(i).get(j)==num){//es que esta el carton, por lo que tachamos
                    tachar(colsCart.get(i),j);//le mandamos la columna y la posicion del elemento a tachar detro de esa col.
                }
            } 
        }
    }
    public void tachar(Columna col, int fila) throws BingoExcepcion, LineaExcepcion{
        //quito numero del carton
        col.set(fila, 0);//ponemos cero en el elemento cuya posicion es igual al numero sacado por el bombo.
        //compruebo si hay numeros en el carton, si hay compruebo linea,  si no   lanxamos excepcion BINGO!!
        //compruebo linea, si no hay  lanzamos excepcion LINEA!
        int contador=0;
        if(cartonPremio()==true){
            throw new BingoExcepcion("¡BINGO!"); 
        }
        if(lineaPremio(fila)==true){
            throw new LineaExcepcion("¡LINEA!");
        }
    }
    
    @Override
    public String toString() {
        //imprimir cada linea, es decir, los numeros de 9 en 9
        String cad="";
        for (int j = 0; j < 3; j++) { 
        // esto imprime una fila j del carton
            for (int i = 0; i < colsCart.size(); i++) {
                cad+=colsCart.get(i).get(j)+"\t";
            }
            cad+="\n";
        }
        return cad;
    }
    
    public int[][] toStringInterface() {
        //imprimir cada linea, es decir, los numeros de 9 en 9
        int[][] cad= new int[3][9];
        for (int j = 0; j < 3; j++) { 
        // esto imprime una fila j del carton
            for (int i = 0; i < colsCart.size(); i++) {
                cad[j][i]=colsCart.get(i).get(j);
            }
        }
        return cad;
    }
    private boolean cartonPremio() {
        boolean res=false;
        int cont=0;
        for (int i = 0; i < 3; i++) {
            if(lineaPremio(i)){
                cont++;
            }
        }
        if(cont==3){
            res=true;
        }
        return res;
    }

    private boolean lineaPremio(int fila) { //me dice si una linea es premiada, osea, todos sus elementos son 0.
        boolean res=false;
        int i=0;
        for (i = 0; i < 9 && colsCart.get(i).get(fila)==0; i++) {
            //la fila es un elemento fijo de cada columna en mi array.
        }
        res=(i==9);//esto devuelve true y se lo asigna a res si hay 9 ceros.
        return res;
    }
}
