package corso;

import java.util.concurrent.TimeUnit;

public class Task extends Thread{

	public synchronized void run() {
		for(int i=2;i<=10;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			}catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
}
