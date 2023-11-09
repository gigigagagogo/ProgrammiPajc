package it.unibs.fp.pajc;

//import it.unibs.pajc.MyTask;

public class TheadApp {

	public static void main(String[] args) {
		/*
		System.out.println("Avvio....");
		MyTask task0= new MyTask("task0",100,10);
		Thread thread0= new Thread(task0);
		Thread thread1= new Thread(task0);
		System.out.println("Fine....");
		
		thread0.start();
		thread1.start();
		task0.run();
		*/
		
		/*
		//Definire il compito che poi il thread andra ad eseguire
		System.out.println("Avvio");
		Runnable task = ()-> {
			//Ci dice il nome(numero progressivo) del Thread che esegue questo codice
			String threadName= Thread.currentThread().getName();
			System.out.printf("Hello + %s\n",threadName);
		};
		
		for(int i=0; i<10;i++) {
			//Crea un oggetto che poi potrai agganciare ad un Thread che verra agganciato quando avviamo il processo
			Thread thread = new Thread(task);
			//Comando per far partire un Thread
			thread.start();
		}
		System.out.println("Fine");
		task.run();
		
		*/
		
		
	}

}
