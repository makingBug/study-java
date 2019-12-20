package MultiThreads;



class SafeWeb12306 implements Runnable{
	//票数
	int ticketNums = 100000;
	int count = 0;
	@Override
	public void run() {
		//正常输出是不应有0的，且每个数都不能一样，
		while(ticketNums > 0) {
			test();
		}
	}
	
	public synchronized void test() {
		if(ticketNums > 0) {
//			System.out.println(Thread.currentThread().getName() +" 买到票："+ticketNums +" 号");
			ticketNums --;
			count ++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SafeWeb12306 web = new SafeWeb12306();	
		Thread t1 = new Thread(web,"1");
		Thread t2 = new Thread(web,"2");
		Thread t3 = new Thread(web,"3");
		Thread t4 = new Thread(web,"4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println(Thread.activeCount());
		while(Thread.activeCount() != 1) {
			System.out.println("t1状态："+t1.getState());
			System.out.println("t2状态："+t2.getState());
			System.out.println("t3状态："+t3.getState());
			System.out.println("t4状态："+t4.getState());
			Thread.sleep(2);
		}
		System.out.println(Thread.activeCount());
		System.out.println(web.count);
		
	}	
}
