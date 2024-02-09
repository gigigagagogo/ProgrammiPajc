package Thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService mauro= Executors.newFixedThreadPool(1);
		MyTask task=new MyTask("A", 0,100);
		MyTask task2=new MyTask("B", 101,200);
		MyTask task3=new MyTask("C", 201,300);
		mauro.submit(task);
		mauro.submit(task2);
		mauro.submit(task3);
		
		try {
			System.out.println("Prova spegnimento....");
			mauro.shutdown();
			mauro.awaitTermination(1, TimeUnit.SECONDS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			mauro.shutdownNow();
		}
		
		/*
		Runnable task = () -> {
			String nome= Thread.currentThread().getName();
			System.out.printf("Thread:%s\n", nome );
		};
		
		task.run();
		
		Thread th = new Thread(task);
		th.start();
		
		System.out.println("Mauro Inzaghi");
		*/
	}
	
}
