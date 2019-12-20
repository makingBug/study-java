package MultiThreads;

/*
 * 死锁：过多的同步可能会造成相互不释放资源，从而相互等待，一般发生于同步中持有多个对象的锁
 * 
 * 避免死锁：不要在同一个代码块中持有多个对象的锁
 */
public class DeadLock {
	public static void main(String[] args) throws InterruptedException {
		Markup g1 = new Markup(1, "培培");
		Markup g2 = new Markup(0, "老崔");
		g1.start();
		g2.start();
		Thread.sleep(5000);
		System.out.println("5s了还没结束，死锁了，2s后结束程序");
		Thread.sleep(2000);
		System.out.println("game over");
		System.exit(0);
	}
}

//镜子
class Mirror{
	
}

//口红
class Lipstick{
	
}

//化妆
class Markup extends Thread{
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	int choice;//选择 1表示镜子，0表示口红
	String girl;//名字
	public Markup(int choice,String girl) {
		this.choice = choice;
		this.girl = girl;
	}
	
	public void run() {
		markup();
	}
	
	//相互持有对方的对象锁---》可能造成死锁
	private void markup() {
		if(choice == 0) { 
			synchronized (lipstick) {//获得口红的锁
				System.out.println(this.girl+"获得口红");
				//1s后想拥有镜子
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (mirror) {
					System.out.println(this.girl+"获得镜子");
				}
			}
//			synchronized (mirror) {
//				System.out.println(this.girl+"获得镜子");
//			}
		}else {
			synchronized (mirror) {//获得镜子的锁
				System.out.println(this.girl+"获得镜子");
				//1s后想拥有镜子
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				
				synchronized (lipstick) {
					System.out.println(this.girl+"获得口红");
				}
			}
//			synchronized (lipstick) {
//				System.out.println(this.girl+"获得口红");
//			}
		}
	}
}