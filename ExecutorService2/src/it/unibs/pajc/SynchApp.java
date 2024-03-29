package it.unibs.pajc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchApp {
	public static void main(String [] args) throws Exception{
		//Se utilizzassi piu thread ci si sarebbe un problema di perdita dati, perchè magari dei thread vanno in conflitto eseguendo nello stesso istante
		//il metodo inc() ed è come se lo facciamo 1 sola volta 
		
		//Tecninca piu semplice per risolvere la concorrenza di thread è scrivere nel codice quali porzioni possono essere fatte in parallelo e quali no
		//perchè crea casino
		
		ExecutorService exec= Executors.newFixedThreadPool(2);
		int d=0;
		AtomicInteger ai= new AtomicInteger();
		Counter counter= new Counter();
		for(int i=0;i<10000;i++) {
			//Uguale a scrivere () -> counter.count
			exec.submit(counter::inc);
		}
		exec.awaitTermination(60, TimeUnit.SECONDS);
		exec.shutdown();
		System.out.printf("Counter: %d",counter.count );
		
	}
		
		Se
	}


class Counter{
	int count=0;
	//Dichiare un metodo sincronizzato vuol dire che da qui non passo piu di 1 thread per volta
	synchronized void inc() {
		count++;
	}
}
