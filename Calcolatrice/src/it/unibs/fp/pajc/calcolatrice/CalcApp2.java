package it.unibs.fp.pajc.calcolatrice;

import java.util.HashMap;

public class CalcApp2 {
	public static void main(String[] args) {
		
		double a=2.;
		double b=3.;
		char ch= '+'; //+,-,*,/
		double res=0.; 
		Somma somma= new Somma();
		System.out.printf("%s" , somma.getClass());
		
		HashMap <Character,OperatoreBinario> hash=new HashMap<>();
		hash.put('+', new Somma());
		hash.put('-', new Differenza());
		hash.put('/', new Divizione());
		hash.put('*', new Moltiplicazione());
		
		OperatoreBinario op= hash.get(ch);
		res=op.eval(a, b);
		System.out.printf("\n%f %c %f = %f ", a, ch, b, res);
		
	}

}
