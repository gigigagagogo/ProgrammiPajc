package esa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		long x=scanner.nextLong();
		int y=scanner.nextInt();
		
		System.out.println(thPrimo(x, y));
		
		
		
	}
	
	public static boolean isPrimo(long x) {
		for(long i=2;i<x;i++) {
			if(x%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int intervalloPrimo(long x,long y) {
		int c=0;
		for(long i=x; i<=y; i++) {
			if(isPrimo(i)) {
				c++;
			}
		}
		return c;
	}
	
	public static int isGemelli(long x,long y) {
		int c=0;
		for(long i=x; i<=y;i++) {
			if(isPrimo(i) && (i+1)%2==0) {
				c++;
			}
		}
		return c;
	}
	
	
	public static int thPrimo(long x, int y) {
		ExecutorService executor = Executors.newFixedThreadPool(y);
		
		ArrayList<Callable<Boolean>> listTask = new ArrayList<>();
		int counter=0;
		
		for(long i=2;i<=x;i++) {
			final long num=i;
			listTask.add(()-> isPrimo(num));
		}
		try {
			
			ArrayList<Future<Boolean>> listResult = (ArrayList<Future<Boolean>>)executor.invokeAll(listTask);
			for(Future<Boolean> lista: listResult) {
				if(lista.get()) {
					counter++;
				}
			}
		executor.shutdown();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			executor.shutdownNow();
		}
		return counter;
	}
	

}

