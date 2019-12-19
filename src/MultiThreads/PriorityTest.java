package MultiThreads;


/*
 * 线程的优先级1-10
 * 所有线程默认优先级都是5
 * 数字越大优先级越高，代表只能的可能性大，不是绝对先执行
 */

public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority()); //获取线程优先级
		MyPriority mp = new MyPriority();
		Thread t1 = new Thread(mp);
		Thread t2 = new Thread(mp);
		Thread t3 = new Thread(mp);
		Thread t4 = new Thread(mp);
		Thread t5 = new Thread(mp);
		Thread t6 = new Thread(mp);
		
		//设置优先级在启动之前
		t1.setPriority(1);
		t2.setPriority(2);
		t3.setPriority(3);
		t4.setPriority(4);
		t5.setPriority(5);
		t6.setPriority(6);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
		Thread.yield();
	}
	
}
