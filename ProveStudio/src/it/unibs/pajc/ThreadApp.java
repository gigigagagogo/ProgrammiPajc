package it.unibs.pajc;

public class ThreadApp  {

	public static void main(String[] args)  {
		prova1();
		
		
	}
	
	public static void prova1() {
		Runnable task= () ->{
			Thread.currentThread().setPriority(1);
			System.out.printf("Nome: %s - Priorita: %s\n",Thread.currentThread().getName(), Thread.currentThread().getPriority());
			System.out.println(Thread.currentThread().getStackTrace());
		};
	
		
		task.run();
		Thread th1=new Thread(task);
		th1.start();
		System.out.println("Fatto");
	}

	
	
}
