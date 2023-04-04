/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mealycolores;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JuanMiguelC
 */
public class Estado {

    private Proceso prs = new Proceso();
    public String nombre;
    public ArrayList<Integer> entradas = new ArrayList();
    public ArrayList<Integer> salidas = new ArrayList();
    private Col col = new Col();
    public int uso = 0, recursividad = 0;

    public Estado(String nombre) {
        this.nombre = nombre;
        col.ini();
    }

    public void añadirUso() {
        this.uso++;
    }

    public void añadirRecursividad() {
        this.recursividad++;
    }

    public int evaluarEntrada(int entrada) {
        int salida = 0;
        if (!entradas.contains(entrada)) {
            
            entradas.add(entrada);
           
        }
        salida = añadirSalida(entrada);
        return salida;
    }

    private int añadirSalida(int entrada) {
        
        int salida = 0;
        int estadoActual = Arrays.asList(prs.colores).indexOf(nombre);//se establece el estado actual
        //int estadoActual = estado;
        if (estadoActual == 0) {
            salidas.add(entrada);
            salida = entrada;
        } else {
            int indx = -1;
            boolean found=false;
            
            for (int j = 0; j < col.colores.length && !found ; j++) {
                if((col.colores[j][0] == estadoActual) && (col.colores[j][1] == entrada)){
                    //System.out.println("--------"+col.colores[j][0] +" "+estadoActual +" || "+col.colores[j][1] +" "+entrada+" || salida "+j);
                    found = true;
                    indx=j;
                }
            }
            salidas.add(col.colores[indx][2]);//dependiendo del estado actual y de la entrada, se etablece la salida
            salida=col.colores[indx][2];
        }
        //System.out.println("salida listaa de colores" + salida);
        return salida;
    }

}
