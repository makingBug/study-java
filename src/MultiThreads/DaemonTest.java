package MultiThreads;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 守护线程：是为用户提供服务的，jvm不用停止等待守护线程执行完毕
 * 默认：jvm等待用户线程执行完毕才会停止
 */

public class DaemonTest {
	public static void main(String[] args) {
		Thread t = new Thread(new Log());
		t.setDaemon(true); //将用户线程调整为守护,可以用来做后台程序记录日志
		
		new Thread(new Program()).start();
		t.start();
	}
}


class Program implements Runnable{

	@Override
	public void run() {
		for(int i =1;i<=50;i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("oooooooo........");
	}
	
}
class Log implements Runnable{
	@Override
	public void run() {
		while(true) {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			System.out.println(format.format(date) + " 程序运行正常");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}