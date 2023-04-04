/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mealycolores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JuanMiguelC
 */
public class Col {

    public int colores[][] = new int[85][3];

    public void ini() {
        ArrayList<Integer> numeros = new ArrayList<>();
        try {
            File archivo = new File("src\\main\\java\\com\\mycompany\\mealycolores\\numeros.txt").getAbsoluteFile();
            //System.out.println(archivo);
            Scanner scanner = new Scanner(archivo);
            //Scanner scanner = new Scanner(new File("C:\\Users\\JuanMiguelC\\Documents\\NetBeansProjects\\mealyColores\\src\\main\\java\\com\\mycompany\\mealycolores\\numeros.txt"));
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        int z = 0;
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 6; j++) {
                colores[z][0] = i;
                colores[z][1] = j;
                colores[z][2] = numeros.get(z);
                z++;
            }
        }
        int fin = colores.length;
        //System.out.println("COLOR "+colores[83][0]+" "+colores[83][1]+" "+colores[83][2]);

    }
}
