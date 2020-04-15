
package com.mycompany.fractals;

import java.awt.Container;
import javax.swing.JFrame;

/**
 * Creates a window to draw the Mandelbrot set on.
 * 
 * @author Brian Cochran
 * @version 4/15/2020
 */
public class Simple extends JFrame {

    private static final int WINDOW_WIDTH = 512;
    private static final int WINDOW_HEIGHT = 512;
    private static final String WINDOW_TITLE = "Mandelbrot";
    
    /**
     * Simple constructor.
     * <p>
     * Creates an instance of the Simple class with a specified width, height, 
     * and title. It also creates an instance of the SimpleBitMap class to create 
     * a panel.
     */
    public Simple() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle(WINDOW_TITLE);
        
        Container pane = this.getContentPane();
        SimpleBitMap panel = new SimpleBitMap();
        pane.add(panel);
        this.setVisible(true);
    }// Simple()
    
    /**
     * Creates a window with a panel containing a drawing of the Mandelbrot set.
     * 
     * @param args string array containing command-line arguments
     */
    public static void main(String[] args) {
        Simple simple = new Simple();
    }// main(String[])
} // Simple
