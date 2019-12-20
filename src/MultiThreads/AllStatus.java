package MultiThreads;

import java.lang.Thread.State;

public class AllStatus implements Runnable{
	
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(new AllStatus());
		
		//观察状态
		State state = t.getState();//刚开始创建一个线程还没有启动，这时是NEW状态
		System.out.println("23行代码输出："+state); //NEW
		
		t.start();
		
		//RUNNABLE是运行态或就绪态，根据源码注释描述：处于RUNNABLE状态的线程正在java虚拟机中执行，但它也可能正在等待
		//来自操作系统的其他资源，例如处理器
		System.out.println("29行代码输出："+t.getState());//RUNNABLE
		
		
		for(int i = 0;i<5;i++) {
			System.out.println("33行代码输出："+t.getState());
			Thread.sleep(100);
		}
	}
}
