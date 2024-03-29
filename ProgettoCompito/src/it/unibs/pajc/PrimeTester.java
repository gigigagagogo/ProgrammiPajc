package it.unibs.pajc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeTester implements Callable<Long> {

	private long start;
	private long end;
	private long nprimi;
	PrimeTester(long start,long end){
		this.start=start;
		this.end=end;
	}
	
	
	private long intervallo= end/4;
	
	public static boolean isPrime(long n) {
		
		/*
		for(long i=2; i<n;i++) {
			if(i%n==0) {
				return false;
			}
		}
		return true;
		*/
		
		if(n==2) {
			return true;
		}
		if(n<=1 || n%2==0) {
			return false;
		}
		long imax=(long)Math.sqrt(n);
		
		for(long i=3;i<=imax;i+=2) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
		 
		 
		 
	}
	
	
	@Override
	public Long call() throws Exception {
		nprimi=0;
		for(long i=start;i<=end;i++) {
			if(isPrime(i)) {
				nprimi++;
			}
		}
		return nprimi;
	}

}
