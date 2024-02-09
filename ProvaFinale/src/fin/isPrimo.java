package fin;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class isPrimo {

	public static void main(String[] args) {

	}

	private static boolean isPrimo(long k) {
		for(long i=2;i<k;i++) {
			 if(k%i==0) {
				 return false;
			 }
		}
		return true;
	}
	
	
	private static boolean isPrimoInt(long k,long x) {
		long min = (long)Math.min(k, x);
		long max = (long)Math.max(k, x);
		for(long i=min;i<=max;i++) {
			 if(x%k==0) {
				 return false;
			 }
		}
		return true;
	}
	
	private static int isGemelli(long x,int y) {
		ArrayList<Callable<Boolean>> listTask = new ArrayList<>();
		int counter=0;
		ExecutorService exec = Executors.newFixedThreadPool(y);
		
		for(long i=2; i<=x;i++) {
			final long currentNumber=i;
			listTask.add(() -> isPrimo(currentNumber));
		}
		try {
			
			ArrayList<Future<Boolean>> result = (ArrayList<Future<Boolean>>)exec.invokeAll(listTask);
			for(Future<Boolean> lista: result) {
				if(lista.get()) {
					counter++;
				}
			}
			exec.shutdown();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			exec.shutdownNow();
		}
		return counter;
		
		
	}
	
	
}
