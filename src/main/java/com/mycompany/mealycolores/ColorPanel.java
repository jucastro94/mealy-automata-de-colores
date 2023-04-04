/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mealycolores;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author JuanMiguelC
 */
public class ColorPanel extends JPanel  {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10; 
        int y = 10; 
        int size = 50; // Tamaño de los cuadros
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW}; // Array de colores
        
        for (Color c : colors) {
            g.setColor(c);
            g.fillRect(x, y, size, size);
            y += size + 10; 
        }
    }
}
