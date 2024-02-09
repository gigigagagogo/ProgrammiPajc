package corso;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		Task task = new Task();
		task.start();
		System.out.println(Thread.currentThread().getName());
		Runnable mytask = () -> {
			for(int i=1;i<10;i++) {
				if(i%2!=0) {					
					System.out.println(i);
				}
				try {
					TimeUnit.MILLISECONDS.sleep(250);
				}catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		};
		Thread th = new Thread(mytask);
		th.start();
		System.out.println(th.getName());
		
	}

}
