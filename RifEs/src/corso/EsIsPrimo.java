package corso;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class EsIsPrimo {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		long x= scan.nextLong();
		long x2= scan.nextLong();
		int y=scan.nextInt();
		System.out.println(thPrimo(x, y));
		
	}
	
	private static boolean isPrimo(long x) {
		for(long i=2;i<x;i++) {
			if(x%i==0) {
				return false;
			}
		}
		return true;
	}
	
	private static int primoInt(long x,long y) {
		int counter=0;
		for(long i=x;i<y;i++) {
			if(isPrimo(i)) {
				counter++;
			}
		}
		return counter;
	}
	
	private static int isGemelli(long x,long y) {
		int counter=0;
		for(long i=x;i<=y;i++) {
			if(isPrimo(i) && (i+1)%2==0) {
				counter++;
			}
		}
		return counter;
	}
	
	private static int thPrimo(long x,int y) {
		ExecutorService executor = Executors.newFixedThreadPool(y);
		ArrayList<Callable<Boolean>> listTask = new ArrayList<>();
		
		for(long i=2;i<=x;i++) {
			final long currentNumber=i;
			listTask.add(() ->isPrimo(currentNumber));
		}
		
		int counter=0;
		
		try{
			ArrayList<Future<Boolean>> listResult = (ArrayList<Future<Boolean>>)executor.invokeAll(listTask);
			
			for(Future<Boolean> lista : listResult) {
				if(lista.get()) {
					counter++;
				}
			}
			executor.shutdown();
		}catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally {
			executor.shutdownNow();
		}
		
		return counter;
		
		
	}
	
}
