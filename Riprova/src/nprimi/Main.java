package nprimi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Avvio....");
		Scanner scan = new Scanner(System.in);
		long n1=scan.nextLong();
		
		if(primo(n1)) {
			System.out.println("mayro");
		}
		
		long n2=scan.nextLong();
		System.out.println(isGemelli(n1, n2));
		
		long x=scan.nextLong();
		int y=scan.nextInt();
		
		int value=(int) x/y;
		
		System.out.println(tprimo(x, y));
		
	}
		
	private static boolean primo(long n) {
		for(int i=2;i<n;i++) {
			if(n%i==0) {				
				return false;
			}
		}
		return true;
		
	}	
	private static int quantiPrimi(long n1,long n2) {
		int c=0;
		for(long i=n1;i<=n2;i++) {
			if(primo(i)) {
				c++;
			}
		}
		return c;
	}
	private static int isGemelli(long n1,long n2) {
		int c=0;
		for(long i=n1;i<=n2-1;i++) {
			if(primo(i) && (i+1)%2==0) {
				c++;
			}
		}
		return c;
	}
	
	private static int tprimo(long numero,int y) {
		int counter=0;
		ExecutorService exec=Executors.newFixedThreadPool(y);
		ArrayList<Callable<Boolean>> listaMetodi = new ArrayList<Callable<Boolean>>();
		for(long i=2;i<=numero;i++) {
			final long num=i;
				listaMetodi.add(() -> primo(num));
		}

		try{
			ArrayList<Future<Boolean>> ris = (ArrayList<Future<Boolean>>)exec.invokeAll(listaMetodi);
			for(Future<Boolean> result: ris) {
				if(result.get()) {
					counter++;
				}	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			exec.shutdownNow();
		}
			
		return counter;
	}

}
