package MultiThreads;

import java.lang.Thread.State;

public class AllStatus {
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for (int i = 0;i<5;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("...");
			}
			
		});
		//观察状态
		State state = t.getState();//刚开始创建一个线程还没有启动，这时是NEW状态
		System.out.println(state); //NEW
		
		t.start();
		state = t.getState();
		//RUNNABLE是运行态或就绪态，根据源码注释描述：处于RUNNABLE状态的线程正在java虚拟机中执行，但它也可能正在等待
		//来自操作系统的其他资源，例如处理器
		System.out.println(state);
		
		
		
		while(state != Thread.State.TERMINATED) { //TIMED_WAITING
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = t.getState();
			int num = Thread.activeCount(); //活动的线程数
			System.out.println(num);
			System.out.println(state);
		}
		//TERMINATED
		
		
	}
}
