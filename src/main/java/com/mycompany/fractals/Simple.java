/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fractals;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Brian Cochran
 */
public class Simple extends JFrame {
    
    private static final int SIMPLE_WIDTH = 512;
    private static final int SIMPLE_HEIGHT = 512;
    private static final String SIMPLE_TITLE = "Simple";
    
    public Simple() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);
        
        Container pane = this.getContentPane();
        
        SimpleBitMap panel = new SimpleBitMap();
        pane.add(panel);
        
        this.setVisible(true);
    } // Simple()
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    } // main(String[])
} // Simple
