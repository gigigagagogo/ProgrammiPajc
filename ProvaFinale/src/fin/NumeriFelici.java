package fin;

import java.util.HashSet;

public class NumeriFelici {

	
	public static void main(String[] args) {
		
	}
	
	public static boolean isFelice(int k) {
		return velocitaFelice(k)>=0;
	}
	
	public static int velocitaFelice(int k) {
		HashSet<Integer> list = new HashSet<>();
		int c=0;
		while(k!=1 && !list.contains(k)) {
			list.add(k);
			c++;
			k=contaSomma(k);
		}
		return (k==1) ? c : -1;
	}
	
	public static int contaFelici(int k) {
		int c=0;
		for(int i=1; i<=k;i++) {
			if(isFelice(k)) {
				c++;
			}
		}
		return c;
	}
	
	public static int contaSomma(int k) {
		int c=0;
		int somma=0;
		while(k>0) {
			c=k%10;
			somma=(int) Math.pow(c, 2);
			k=k/10;
		}
		
		return somma;
	}
	

}
