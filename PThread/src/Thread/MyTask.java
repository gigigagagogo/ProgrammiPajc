package Thread;

import java.util.concurrent.Callable;

public class MyTask implements Runnable{

	private String taskName;
	private int first;
	private int end;
	
	public MyTask(String taskName,int first,int end) {
		this.taskName = taskName;
		this.first = first;
		this.end = end;
	}
	
	public void run() {
		for(int i=first;i<end;i++) {
			System.out.printf("\n%s, line: %3d [%s]",taskName,i,Thread.currentThread().getName());			
		}
	}
	
}
