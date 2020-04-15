
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

/**
 * The SimpleBitMap class creates an image of the Mandelbrot set.
 * <p>
 * Maps complex numbers to locations of pixels on screen and colors pixels according 
 * to checkPoint value. Zooms in on Mandelbrot set at a specified rate.
 * 
 * @author Brian Cochran
 * @version 4/15/2020
 */
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
    
    /**
     * SimpleBitMap constructor.
     * <p>
     * Creates an instance of the class and starts a timer. Sets the bounds of 
     * the created image.
     */
    public SimpleBitMap() {
        Timer timer = new Timer(20, this);
        timer.start();
        
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    }// SimpleBitMap()
    
    /**
     * Maps x,y coordinates to complex numbers.
     * <p>
     * This method maps the real plane to the complex plane. These two planes are 
     * described by predefined instance variables.
     * 
     * @param x x-coordinate to map
     * @param y y-coordinate to map
     * @return new complex number
     */
    public Complex mapping(double x, double y) {
        double u = minU + (maxU - minU) * ((x - minX) / (maxX - minX));
        double v = minV + (maxV - minV) * ((y - minY) / (maxY - minY));
        return new Complex(u, v);
    }// mapping(Complex)
    
    /**
     * Checks the likelihood that a complex number is within the Mandelbrot set.
     * <p>
     * To do this, the method constantly updates a complex number z by assigning 
     * z the value of z^2 + c, where c is the complex number taken as a parameter. 
     * When the magnitude or the number of iterations reaches a specified number, 
     * the while loop breaks and the number of iterations is returned, which is used 
     * to determine the color a pixel should be.
     * 
     * @param c complex number to check
     * @return (int) number of iterations in while loop
     */
    public int checkPoint(Complex c) {
        Complex z = new Complex(0, 0);
        int count = 0;
        while(z.magnitudeSquared() < 3 && count < 100) {
            z = z.multiply(z);
            z = z.add(c);
            count++;
        }// while
        return count;
    }// checkPoint(Complex c)
    
    /**
     * Selects a color for a pixel.
     * <p>
     * When a pixel is mapped to a complex number, that complex number is put into 
     * the checkPoint method. The value returned is used in this method to choose 
     * a color for the pixel to be. The red of each pixel is this value divided by 
     * two, the green is this value times 2, and the blue is this value. The red, 
     * green, and blue are put into an integer array and returned as the color.
     * 
     * @param value value returned from checkPoint method
     * @return (int[]) color
     */
    public int[] chooseColor(int value) {
        int[] color = {value / 2, value * 2, value};
        return color;
    } // chooseColor(int)
    
    /**
     * Paints the Mandelbrot set picture.
     * <p>
     * Sets each individual pixel to a color determined by the chooseColor method. 
     * It does this with a nested for loop that maps each pixel to a complex number, 
     * gets the value of the checkPoint method for that complex number, and inputs 
     * that into the chooseColor method.
     * 
     * @param g Graphics object
     */
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
    
    /**
     * Animates Mandelbrot set picture.
     * <p>
     * Reassigns min and max values for u and v coordinates so that it appears as 
     * though the image is zooming in. A new picture with edited bounds is produced 
     * according to the timer started in the SimpleBitMap constructor.
     * 
     * @param e ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.maxU = this.maxU - (double) ((this.maxU - this.minU) / 150);
        this.minU = this.minU + (double) ((this.maxU - this.minU) / 150);
        this.maxV = this.maxV - (double) ((this.maxV - this.minV) / 150);
        this.minV = this.minV + (double) ((this.maxV - this.minV) / 150);
        this.repaint();
    } // actionPerformed(ActionEvent)
} // SimpleBitMap
