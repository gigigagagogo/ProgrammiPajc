package it.unibs.pajc;
//Classe per costrutire dei task che possono essere assegnati ai Thread

import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer>{
	
	private String name;
	//private int nStep;
	private int delay;//ms
	
	
	
	public MyTask(String name,int delay) {
		super();
		this.name = name;
		this.delay = delay;
	}

	public Integer call() throws Exception {
		int nStep= 5000 / delay;
		for(int i=0;i<nStep;i++) {
			System.out.printf("\n%s - step: %3d [%s]",name,i,Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(delay);
			}catch(InterruptedException ex) {
				
			}
		}
		return nStep;
		
		
	}
	
}
