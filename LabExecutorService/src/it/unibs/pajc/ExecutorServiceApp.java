package it.unibs.pajc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//classe di factory il cui scopo è creare oggetti istanza di qualcos'altro tramite costruttori
public class ExecutorServiceApp {
	public static void main(String[] args) throws Exception {
		//executor crea 2 thread
		//La dimensione da dare a newFixedThreadPool dipende dai core del nostro processore
		//La dimensione che gli diamo sono i thread che vengono lavorati in parallelo
		ExecutorService executor= Executors.newFixedThreadPool(3);
		
		//Gli oggetti Future sono in grado di comunicare con i task e valorizzano i propri valori interni in funzione del valore risultato del task abbinato
		Future<Integer> fa=executor.submit(new MyTask("A", 42));
		Future<Integer> fb=executor.submit(new MyTask("B", 31));
		Future<Integer> fc=executor.submit(new MyTask("C", 23));
		Future<Integer> fd=executor.submit(new MyTask("D", 33));
		
		System.out.printf("\nA: %d", fa.get());
		System.out.printf("\nB: %d", fb.get());
		System.out.printf("\nC: %d", fc.get());
		System.out.printf("\nD: %d", fd.get());
		executor.shutdown();
		System.out.printf("\n\n %s", executor.isTerminated() ? "Si" : "No");
		//Questa è un'altra possibilita di creare un ExecutorService la differenza è che la dimensione non dobbiamo metterla
		//noi ma la nostra macchina lo metta in automatica cercando di ottimizzare il tutto
		//ExecutorService executor2= Executors.newCachedThreadPool();
		
		//executor con 1 solo theread(Applicazione single thread) => le nostre task vengono eseguite 1 alla volta
		//Il motivo del perche usare 1 solo thread anziche di più è che cosi siamo sicuri che le task verrano svolte nell'ordine 
		//che vogliamo noi
		//ExecutorService executor3= Executors.newSingleThreadExecutor();
		
		
		//Diamo delle task(Oggetti di tipo runnable/collable(Interfaccia che non prende parametri in input ma restituisce un parametro che noi vogliamo)) 
		//da fare a executor
		/*
		executor.submit(new MyTask("A",42));
		executor.submit(new MyTask("B",31));
		executor.submit(new MyTask("C",23));
		executor.submit(new MyTask("D",33));
		*/
		//L'ExecutorService gestisce i Thread da solo, lui capisce quando ha finito e lui assegna ad un thread un nuovo lavoro
		System.out.println("\nFatto");
		
		//Dobbiamo dire al ExecutorService che non gli daremo piu task altrimenti il programma non terminerebbe perché l'executor
		//Service rimarebbe in attesa di nuove task
		//Dire ad un ExecutorService di spegnarsi vuol dire che una volta che lui ha finito di fare tutte le task che gli sono state 
		//sottomesse si può spegnere, non nel mentre
		
		//Comando per dire all'executor che non avra più task su cui lavorare 
		executor.shutdown();
	}

}
