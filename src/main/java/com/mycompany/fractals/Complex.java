
package com.mycompany.fractals;

public class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }// Complex(double, double)

    public Complex add(Complex c) {
        double u = this.real + c.real;
        double v = this.imaginary + c.imaginary;
        
        return new Complex(u, v);
    }// add(Complex)

    public Complex multiply(Complex c) {
        double u = (this.real * c.real) - (this.imaginary * c.imaginary);
        double v = (this.real * c.imaginary) + (c.real * this.imaginary);
        return new Complex(u, v);
    }// multiply(Complex)

    public double magnitudeSquared() {
        double rSquare = this.real * this.real;
        double iSquare = this.imaginary * this.imaginary; 
        return rSquare + iSquare;
    }// magnitudeSquared()

    public double getReal() {
        return this.real;
    }// getReal()

    public double getImaginary() {
        return this.imaginary;
    }// getImaginary()
}// Complex