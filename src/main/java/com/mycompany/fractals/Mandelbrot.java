/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fractals;

/**
 *
 * @author Brian Cochran
 */
public class Mandelbrot {
    
    private Complex c;
    private double uMin;
    private double uMax;
    private double vMin;
    private double vMax;
    
    public Mandelbrot(double uMin, double uMax, double vMin, double vMax) {
        this.uMin = uMin;
        this.uMax = uMax;
        this.vMin = vMin;
        this.vMax = vMax;
    } // Mandlebrot(double, double, double, double)
    
    public Complex mapping(int x, int y, int xMin, int xMax, int yMin, int yMax) {
        double u = (double) this.uMin + ((double) (this.uMax - this.uMin) * ((double) (x - xMin) / (xMax - xMin)));
        double v = (double) this.vMin + ((double) (this.vMax - this.vMin) * ((double) (y - yMin) / (yMax - yMin)));
        return new Complex(u, v);
    } // mapping(int, int, int, int, int, int)
    
    public int checkPoint(int x, int y, int xMin, int xMax, int yMin, int yMax) {
        Complex c = this.mapping(x, y, xMin, xMax, yMin, yMax);
        Complex z = new Complex(0, 0);
        int count = 0;
        double magnitude = z.magnitudeSqr();
        while (magnitude < 2 && count < 100) {
            count +=1;
            Complex zSqr = z.multiply(z);
            z = zSqr.add(c);
            magnitude = z.magnitudeSqr();
        } // while
        return count;
    } // checkPoint(Complex, Complex)
} // Mandelbrot