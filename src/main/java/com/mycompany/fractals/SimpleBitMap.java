
package com.mycompany.fractals;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleBitMap extends JPanel implements ActionListener{

    private static final int BITMAP_WIDTH = 475;
    private static final int BITMAP_HEIGHT = 500;
    private final BufferedImage image;
    private final double minX = 0;
    private final double maxX = BITMAP_WIDTH - 1;
    private final double minY = 0;
    private final double maxY = BITMAP_HEIGHT - 1;    
    private double minU = -2;
    private double maxU = 1;
    private double minV = -0.88;
    private double maxV = 2.12;
    
    public SimpleBitMap() {
        Timer timer = new Timer(20, this);
        timer.start();
        
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
        int count = 0;
        while(z.magnitudeSquared() < 4 && count < 100) {
            z = z.multiply(z);
            z = z.add(c);
            count++;
        }// while
        return count;
    }// checkPoint(Complex c)
    
    public int[] chooseColor(int value) {
        int[] color = {value / 2, value * 2, value};
        return color;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.maxU = this.maxU - (double) ((this.maxU - this.minU) / 150);
        this.minU = this.minU + (double) ((this.maxU - this.minU) / 150);
        this.maxV = this.maxV - (double) ((this.maxV - this.minV) / 150);
        this.minV = this.minV + (double) ((this.maxV - this.minV) / 150);
        this.repaint();
    } // actionPreformed(ActionEvent)
} // SimpleBitMap
