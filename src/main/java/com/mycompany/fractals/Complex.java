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
public class Complex {
    
    public static double real;
    public static double imaginary;
    
    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    } // Complex(double, double)
    
    public double getReal() {
        return this.real;
    } // getReal()
    
    public double getImaginary() {
        return this.imaginary;
    } // getImaginary()
    
    public Complex add(Complex c) {
        double newReal = this.getReal() + c.getReal();
        double newImaginary = this.getImaginary() + c.getImaginary();
        return new Complex(newReal, newImaginary);
    } // add(Complex)
    
    public Complex multiply(Complex c) {
        double newReal = (this.getReal() * c.getReal()) - (this.getImaginary() * c.getImaginary());
        double newImaginary = (this.getReal() * c.getImaginary()) - (this.getImaginary() * c.getReal());
        return new Complex(newReal, newImaginary);
    } // multiply(Complex)
    
    public double magnitude() {
        return Math.sqrt((this.getReal() * this.getReal()) + (this.getImaginary() * this.getImaginary()));
    } // magnitude()
} // Complex
