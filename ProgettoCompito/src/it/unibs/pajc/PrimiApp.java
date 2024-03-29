package it.unibs.pajc;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimiApp {

	public static void main(String[] args) throws Exception {
		
		long nMax=10_000_000;
		int nTask=6;
		
		System.out.println("Avvio.....");
		
		ExecutorService executor=Executors.newFixedThreadPool(6);
		
		long valuesPerTask= nMax/nTask;
		
		ArrayList<Future<Long>> results=new ArrayList<>();
		
		Chrono chrono=new Chrono();

		for(int i=0;i<nTask;i++) {
			PrimeTester task = new PrimeTester(i*valuesPerTask+1, Math.min((i+1) * valuesPerTask,nMax));
			results.add(executor.submit(task));
		}
		
		long nprimes=0;
		for(Future<Long> f: results) {
			nprimes += f.get();
		}
		
		chrono.stop();
		
		System.out.printf("\n\nPrimi compresi nell'intervallo: %d - [%s]", nprimes,chrono);
		
	}

}
