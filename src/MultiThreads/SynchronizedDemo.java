package MultiThreads;

/* 
 * 并发测试数据量到达10000以上更容易观察出潜在的问题
 * 
 * run1,锁定代码块竟然比锁定函数更费时，不太理解
 */

public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
    	long t1 = System.currentTimeMillis();
    	SynchronizedDemo thread = new SynchronizedDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(thread).start();
        }
        
        System.out.println(Thread.activeCount());
        while(Thread.activeCount() != 1);
        System.out.println("result: " + count);
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1)+"ms");
        
    }

    @Override
    public void run() {
//    	run1();
    	run2();
    }
    
    public void run1() {
    	for (int i = 0;i < 10000;i++) {
    		synchronized(this) {
    			count++;
    		}
    	}
    }
    public synchronized void run2() {
    	for(int i = 0;i<10000;i++) {
    		count ++;
    	}
    }
    
}