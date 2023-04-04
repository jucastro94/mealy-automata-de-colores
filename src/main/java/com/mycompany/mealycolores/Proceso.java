/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mealycolores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanMiguelC
 */
public class Proceso {

    Conversion convertir = new Conversion();

    public ArrayList<Character> n = new ArrayList(Arrays.asList('1', '2', '3', '4', '5', '6'));

    //public ArrayList<String> numeroColores = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"));
    public String colores[] = {"q0", "amarillo", "azul", "rojo", "verde", "naranja", "violeta", "amarillo naranja", "amarillo verdoso", "azul verdoso", "azul violeta", "rojo violeta", "rojo anaranjado", "marron", "rosado"};

    public ArrayList<Estado> listaTotalidadEstados = new ArrayList();
    public ArrayList<Integer> listaProceso = new ArrayList();
    public ArrayList<String> listaNombresProceso = new ArrayList();
    public ArrayList<String> salidas = new ArrayList();
    public int colorActual, id;
    public String cadnn;
    int indiceSalida;

    public void inicio(String cadena) {
        cadnn = cadena;
        Col color = new Col();
        color.ini();
        listaProceso.add(0);
        listaNombresProceso.add("q0");
        listaTotalidadEstados.add(new Estado("q0"));
        //listaTotalidadEstados.get(0).añadirUso();
        colorActual = 0;
        if (validarCadena(cadena)) {
            for (int i = 0; i < cadena.length(); i++) {
                String Est = colores[convertir.charToInt(cadena.charAt(i))];
                if (valRecursividad(Est)) {
                    id = saberIndiceListaEstados(Est);
                    listaTotalidadEstados.get(id).añadirRecursividad();

                }

                //se envia por parametro el color actual
                indiceSalida = listaTotalidadEstados.get(listaTotalidadEstados.size() - 1).evaluarEntrada(convertir.charToInt(cadena.charAt(i)));
                //.out.println("indice S "+ indiceSalida);

                salidas.add(colores[indiceSalida]);
                colorActual = indiceSalida;
                listaProceso.add(indiceSalida);
                listaNombresProceso.add(colores[indiceSalida]);
                if (!valCrearEstado(indiceSalida) && i < cadena.length() - 1) {
                    //System.out.println("Nuevo: "+colores[indiceSalida]);
                    listaTotalidadEstados.add(new Estado(colores[indiceSalida]));

                }
                id = saberIndiceListaEstados(colores[indiceSalida]);
                listaTotalidadEstados.get(id).añadirUso();
                
            }

        } else {
            JOptionPane.showMessageDialog(null, "la cadena contiene caracteres fuera del alfabeto", "error de cadena", JOptionPane.ERROR_MESSAGE);
        }
        impirmir(cadena);
    }

    //valida que no haya caracteres fuera del alfabeto
    public boolean validarCadena(String cadena) {
        boolean found = true;
        for (int i = 0; i < cadena.length() && found == true; i++) {
            found = n.contains(cadena.charAt(i));
        }
        return found;

    }

    //se valida si hay recursividad de recursividad
    public boolean valRecursividad(String PosibleEstado) {
        int indiceColor = conocerIndiceColor(PosibleEstado);

        if ((listaNombresProceso.get(listaNombresProceso.size() - 1).equals(PosibleEstado)) && (indiceColor >= 0 || indiceColor <= 6)) {

            return true;
        } else {
            return false;
        }
    }

    public int conocerIndiceColor(String color) {
        boolean found = false;
        int indice = 0;
        for (int i = 0; i < colores.length && !found; i++) {
            if (colores[i].equals(color)) {
                found = true;
                indice = i;
            }
        }
        return indice;
    }

    public boolean valCrearEstado(int i) {
        //pasapor parametro el codigo del color
        String color = colores[i];
        boolean found = false;
        for (int j = 0; j < listaTotalidadEstados.size() && !found; j++) {
            if (listaTotalidadEstados.get(j).nombre.equals(color)) {
                found = true;
            }
        }
        return found;

    }

    public void impirmir(String cadena) {
        String lista = "", entrada = "", salida = "", proces = "", cad = "";
        for (int i = 0; i < cadena.length(); i++) {
            cad = cad + colores[convertir.charToInt(cadena.charAt(i))] + " |";
        }
        for (int i = 0; i < salidas.size(); i++) {
            salida = salida + " " + salidas.get(i) + " |";
        }
        for (int i = 0; i < listaProceso.size(); i++) {
            proces = proces + " " + colores[listaProceso.get(i)] + " |";

        }
        for (int i = 0; i < listaTotalidadEstados.size(); i++) {
            lista = lista + " " + listaTotalidadEstados.get(i).nombre + " |";
        }
        //System.out.println("cadena");
        //System.out.println(cad);
        //System.out.println("proceso ");
        //System.out.println(proces);
        //System.out.println("listaTotalidadEstados");
        //System.out.println(lista);
        //System.out.println("salidas");
        //System.out.println(salida);
        /*System.out.println("---------");
        for (int i = 0; i < colores.length; i++) {
            System.out.println(i+" "+colores[i]);
        }
        System.out.println("---------");*/
    }

    public int saberIndiceListaEstados(String color) {
        boolean found = false;
        int indx = 0;
        for (int i = 0; i < listaTotalidadEstados.size() && !found; i++) {
            if (listaTotalidadEstados.get(i).nombre.equals(color)) {
                found = true;
                indx = i;
            }
        }
        return indx;
    }

}
