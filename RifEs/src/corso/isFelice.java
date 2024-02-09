package corso;

import java.util.HashSet;
import java.util.Scanner;


public class isFelice {
	public static void main(String [] ars) {
		Scanner scan = new Scanner(System.in);
		
		int x=scan.nextInt();
	}
	
	public static boolean isFelice(int k) {
		
		return velocitaFelice(k)>=0;
	}
	
	public static int calcolaSomma(int k) {
		int c=0;
		while(k>0) {
			int v=k%10;
			c = (int)Math.pow(v,2);
			k=k/10;
		}
		return c;
	}
	
	public static int contaFelici(int x,int k) {
		int counter=0;
		for(int i=x;i<k;i++) {
			if(isFelice(i)) {
				counter++;
			}
		}
		return counter;
	}
	
	public static int velocitaFelice(int k) {
		HashSet<Integer> result= new HashSet<>();
		int c=0;
		while(k!=1 && result.contains(c)) {
			result.add(k);
			c++;
			k=calcolaSomma(k);
		}
		return (k==1) ? c : -1;
	}
	
}
