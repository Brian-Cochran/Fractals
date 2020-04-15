
package com.mycompany.fractals;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

public class SimpleBitMap extends JPanel {

    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private BufferedImage image;

    private final double minX = 0;
    private final double maxX = BITMAP_WIDTH - 1;
    private final double minY = 0;
    private final double maxY = BITMAP_HEIGHT - 1;    

    private final double minU = -1.3;
    private final double maxU = -0.2;
    private final double minV = -1.3;
    private final double maxV = -0.2;

    private final int MAX_ITERATIONS = 100;
    private final double MAGNITUDE = 4.0;
    
    public SimpleBitMap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    }// SimpleBitMap()
    
    public Complex mapping(double x, double y) {
        double u = minU + (maxU - minU) * ((x - minX) / (maxX - minX));
        double v = minV + (maxV - minV) * ((y - minY) / (maxY - minY));
        return new Complex(u, v);
    }// mapping(Complex)

    public int checkPoint(Complex c) {
        Complex z = new Complex(0, 0);
        int count = -1;
        while(z.magnitudeSquared() < MAGNITUDE && count < MAX_ITERATIONS) {
            z = c.add(z.multiply(z));
            count++;
        }// while
        return count;
    }// checkPoint(Complex c)
    
    public int[] chooseColor(int value) {
        if (value < 10) {
            int[] color = {0, 0, 0};
            return color;
        } // if
        else {
            int[] color = {0, 255, 0};
            return color;
        } // else
    } // chooseColor(int)
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / BITMAP_WIDTH, ((double) h) / BITMAP_HEIGHT);
        
        WritableRaster raster = this.image.getRaster();
         
        for(int row = 0; row < h; row++) {
            for(int column = 0; column < w; column++) {
                Complex c = mapping(row, column);
                int colorValue = checkPoint(c); 
                int[] color = chooseColor(colorValue);
                raster.setPixel(row, column, color);
            }// for
        }// for
        g2D.drawImage(image, scale, this);
    }// paintComponent(Graphics)
} // SimpleBitMap
