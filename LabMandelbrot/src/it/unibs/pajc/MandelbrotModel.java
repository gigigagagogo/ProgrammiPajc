package it.unibs.pajc;

public class MandelbrotModel {
	
	private double [][] data;

	public double [][] getData(){
		return data;
	}
	
	public void eval (Complex vmin, Complex vmax, int res) {
		
		data = new double [res][res];
		
		double dre =Math.abs(vmin.re - vmax.re)/res;
		double dim =Math.abs(vmin.im-vmax.im)/res;
		   
		for(int i=0;i<res;i++) {
			for(int j=0;j<res;j++) {
				data[i][j] = fMandelbrot(new Complex(vmin.re + j * dre, vmax.im - i*dim));
			}
		}
	}
	
	//Zn+1 = Zn^2 + C
	private static double fMandelbrot(Complex c) {
		int maxi=100;
		
		Complex z= new Complex(c);
		
		for(int i=0; i<maxi;i++) {
			z= z.sqr().sum(c);
			if(z.module2() > 1e5) {
				return(maxi-i)/(double)maxi;
			}
		}
		return 0.;
	}
}
