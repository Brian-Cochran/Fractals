
package com.mycompany.fractals;

/**
 * The Complex class contains methods for creating and editing a complex number.
 * <p>
 * Within this class are methods for creating a complex number, adding, multiplying, 
 * and getting magnitude.
 * 
 * @author Brian Cochran
 * @version 4/15/2020
 */
public class Complex {

    private final double real;
    private final double imaginary;
    
    /**
     * Complex constructor.
     * <p>
     * Creates a complex number.
     * 
     * @param r real number
     * @param i imaginary number
     */
    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }// Complex(double, double)
    
    /**
     * Adds a complex number to another one.
     * <p>
     * A complex numbers calls this method to add another complex number to itself.
     * 
     * @param c complex number to be added
     * @return new complex number
     */
    public Complex add(Complex c) {
        double u = this.real + c.real;
        double v = this.imaginary + c.imaginary;
        
        return new Complex(u, v);
    }// add(Complex)
    
    /**
     * Multiplies two complex numbers.
     * <p>
     * A complex number calls this method to multiply itself by another complex 
     * number.
     * 
     * @param c complex number to be multiplied
     * @return new complex number
     */
    public Complex multiply(Complex c) {
        double u = (this.real * c.real) - (this.imaginary * c.imaginary);
        double v = (this.real * c.imaginary) + (c.real * this.imaginary);
        return new Complex(u, v);
    }// multiply(Complex)
    
    /**
     * Gets the magnitude squared of a complex number.
     * 
     * @return (double) magnitude squared
     */
    public double magnitudeSquared() {
        double rSquare = this.real * this.real;
        double iSquare = this.imaginary * this.imaginary; 
        return rSquare + iSquare;
    }// magnitudeSquared()
    
    /**
     * Retrieves the value of the real part of a complex number.
     * 
     * @return (double) real value
     */
    public double getReal() {
        return this.real;
    }// getReal()
    
    /**
     * Retrieves the value of the imaginary part of a complex number.
     * 
     * @return (double) imaginary value
     */
    public double getImaginary() {
        return this.imaginary;
    }// getImaginary()
}// Complex