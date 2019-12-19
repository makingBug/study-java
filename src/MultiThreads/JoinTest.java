package MultiThreads;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()-> {
			for(int i =0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"..."+i);
				
			}
		} ,"线程1");
		t.start();
		Thread t1 = new Thread(()-> {
			for(int i =0;i<5;i++) {
				if(i == 0) {
					try {
						t.join(); //线程2等待线程1执行完毕再执行
					} catch (InterruptedException e) {
					}
				}
				System.out.println(Thread.currentThread().getName()+"..."+i);
				
			}
		},"线程2" ); 
		t1.start();
		for(int i =0;i<5;i++) {
			if(i == 0) {
				t1.join();//main线程等待线程2执行结束再执行
			}
			System.out.println("main..."+i);
		}
	}
}
