
package com.mycompany.fractals;

import java.awt.Container;
import javax.swing.JFrame;

public class Simple extends JFrame {

    private static final int WINDOW_WIDTH = 512;
    private static final int WINDOW_HEIGHT = 512;
    private static final String WINDOW_TITLE = "Mandlebrot";

    public Simple() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle(WINDOW_TITLE);
        
        Container pane = this.getContentPane();
        SimpleBitMap panel = new SimpleBitMap();
        pane.add(panel);
        this.setVisible(true);
    }// Simple()

    public static void main(String[] args) {
        Simple simple = new Simple();
    }// main(String[])
} // Simple
