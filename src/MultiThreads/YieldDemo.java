package MultiThreads;

/*
 * 礼让线程，
 * 在该线程中调用该方法，会使该方法直接进入就绪态，重新与其他线程公平竞争CPU
 * 
 */
public class YieldDemo {
	public static void main(String[] args) {
		MyYield my = new MyYield();
		
		new Thread(my,"线程1").start();
		new Thread(my,"线程2").start();
	}
}

class MyYield implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->start");
		Thread.yield();//礼让
		System.out.println(Thread.currentThread().getName()+"--->end");
	}
	
}