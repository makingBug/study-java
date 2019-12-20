package MultiThreads;

import java.util.concurrent.TimeUnit;

public class AProblem {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		Thread t = new Thread(new MyInfo());

		t.setName("线程t");
		t.start();
		System.out.println(Thread.activeCount());
		while(Thread.activeCount() != 1);
		
		
		System.out.println(t.isAlive());
//		Thread.sleep(100);
		System.out.println(t.getState());
	}
	
	
//	System.out.println();
}

class MyInfo implements Runnable{
	
	public void run() {
		System.out.println("线程名：");
	}
}