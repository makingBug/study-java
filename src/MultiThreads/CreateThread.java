package MultiThreads;

public class CreateThread {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		thread1.start();
		
		Thread thread2 = new Thread(new Thread2());
		thread2.start();
		
		for(int i =0;i<20;i++) {
			System.out.println("我是主线程");
		}
	}
}



/*
 * 创建线程的方式一：
 * 1. 继承Thread类，重写run方法
 */

class Thread1 extends Thread{
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("我是子线程1");
		}
	}
}

/*
 * 创建线程的方式二：
 * 实现runnable接口，实现run方法
 */
class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<20;i++) {
			System.out.println("我是子线程2");
		}
	}
	
}