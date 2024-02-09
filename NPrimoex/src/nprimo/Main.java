 package nprimo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		long num0=scan.nextLong();
		if(primo(num0)) {
			System.out.println("Daje");
		}
		long num1=scan.nextLong(); 
		long num2=scan.nextLong();
		System.out.printf("Numeri primi intervallo:%d\n", nprimi(num1, num2));
		System.out.printf("Numeri gemelli:%d",isGemelli(num1, num2));
		//Numero thread
		
	
	}
	
	private static boolean primo(long n) {
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	private static int nprimi(long num1,long num2) {
		int c=0;
		for(long i=num1;i<=num2;i++) {
			if(primo(i)) {
				c++;
			}
		}
		return c;
	}
	
	private static int isGemelli(long num1,long num2) {
		int c=0;
		for(long i=num1;i<=num2-2;i++) {
			if(primo(i) && primo(i+2) && ((i+1)!=2 && (i+1)%2==0)) {
				c++;
			}
		}
		return c; 
	}

	private static int nprimiMultithreading(long num, int y) {
        ExecutorService executor = Executors.newFixedThreadPool(y);
        ArrayList<Callable<Boolean>> tasks = new ArrayList<>();
        int count = 0;
        for (long i = 3; i < num; i++) {
            final long currentNumber = i;
            tasks.add(() -> primo(currentNumber));
        }
        try{
            ArrayList<Future<Boolean>> results = (ArrayList<Future<Boolean>>) executor.invokeAll(tasks);
            for(var result : results){
                if(result.get()){
                    count++;
                }
            }
        }catch(InterruptedException | ExecutionException e ){
            System.out.println(e.getMessage());
        }finally{
            executor.shutdown();
        }
        return count;
    }
	
}
