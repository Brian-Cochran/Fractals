/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fractals;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

/**
 *
 * @author Brian Cochran
 */
public class SimpleBitMap extends JPanel {
    
    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private BufferedImage image;
    
    public SimpleBitMap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    } // SimpleBitMap()
    
    public int getWidth() {
        return this.BITMAP_WIDTH;
    } // getWidth()
    
    public int getHeight() {
        return this.BITMAP_HEIGHT;
    } // getHeight()
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / BITMAP_WIDTH, ((double) h) / BITMAP_HEIGHT);
        
        WritableRaster raster = this.image.getRaster();
        
        int[] black = {0, 0, 0};
        int[] yellow = {255, 255, 0};
    
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j < i) {
                    raster.setPixel(j, i, yellow);
                } // if
                else {
                    raster.setPixel(j, i, black);
                } // else
            } // for
        } // for
        
        g2D.drawImage(image, scale, this);
    } // paintComponent(Graphics)
} // SimpleBitMap