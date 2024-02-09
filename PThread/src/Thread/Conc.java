package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Conc {

	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		Counter count = new Counter();
		
		for(int i=0;i<10000;i++) {
			exec.submit(count::inc);
		}
		
		try {
			exec.shutdown();
			exec.awaitTermination(60,TimeUnit.SECONDS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			exec.shutdownNow();
		}
		
		System.out.println(count.c);
	}

}

class Counter{
	int c=0;
	synchronized void inc() {
		c++;
	}
}
