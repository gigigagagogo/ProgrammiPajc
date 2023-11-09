package it.unibs.pajc;

public class Complex {
	
	double re;
	double im;
	
	public Complex(double re, double im) {
		this.re=re;
		this.im=im;
	}
	
	public Complex(Complex c) {
		this(c.re,c.im);
	}
	
	public Complex sum(Complex v) {
		return new Complex(re + v.re, im + v.im);
		
	}
	
	public Complex sqr() {
		return new Complex(re*re - im*im, 2*re*im);
	}
	
	public double module2() {
		return re*re + im*im;
	}
	
	
	
}
