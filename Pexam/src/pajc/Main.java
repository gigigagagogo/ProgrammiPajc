package pajc;
import java.util.HashSet;

public class Main {
	public static void main(String [] args){
		System.out.println(isFelice(1));
	}
	
	public static boolean isFelice(int k) {
		return velocitaFelice(k)>=0;
	}
	
	public static int velocitaFelice(int k) {
		int c=0;
		HashSet<Integer> num=new HashSet<>();
		while(k!=1 && !num.contains(k)) {
			num.add(k);
			c++;
			k=contaCifre(k);
		}
		
		//System.out.println(c);
		return (k==1) ? c : -1;
	}
	
	public static int contaCifre(int k) {
		int r=0;
		
		while(k>0) {
			r+= Math.pow(k%10.,2.); 
			k=k/10;
		}
		
		return r;
	}
	
	public static void contaFelici(int k) {
		int c=0;
		for(int i=0;i<k;i++) {
			if(isFelice(i)) {
				c++;
			}
		}
		System.out.println(c);
	}
	
}

