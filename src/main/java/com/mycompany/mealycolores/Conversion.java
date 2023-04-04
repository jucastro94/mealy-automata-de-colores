/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mealycolores;

/**
 *
 * @author JuanMiguelC
 */
public class Conversion {
    public int charToInt(char a){
        int numero = Character.getNumericValue(a);
        return numero;
    }
    public String intToString(int a){
        String caracter= String.valueOf(a);
        return caracter;
    }
}
