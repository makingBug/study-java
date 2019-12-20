package MultiThreads;

public class SynObject {
	public static void main(String[] args) {
		Account account = new Account(1000,"范闲");
		SafeDrawing you = new SafeDrawing(account,80,"范闲");
		SafeDrawing wife = new SafeDrawing(account,90,"林宛儿");
		new Thread(you).start();
		new Thread(wife).start();
		new Thread(you).start();
		new Thread(wife).start();
	}
	
}

//账户
class Account{
	int money;
	String name;
	public Account(int money,String name) {
		this.money = money;
		this.name = name;
	}
}

//模拟取款
class SafeDrawing implements Runnable{
	Account account;//取钱的账户
	int drawingMoney;//取的钱数
	int packetTotal;//口袋的总数
	String name;
	
	public SafeDrawing(Account account,int drawingMoney,String name) {
		this.account = account;
		this.drawingMoney = drawingMoney;
		this.name = name; //取款人
	}

	@Override
	public void run() {
		test();
	}
	
	//目标锁定失败，这里不是锁this，应该锁定account
	public synchronized void test() {
		if(account.money-drawingMoney < 0) {
			return;
		}
		synchronized(account) {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money -= drawingMoney;
			packetTotal += drawingMoney;
			
			System.out.println(name+"取款："+drawingMoney);
			System.out.println(name+"口袋中的钱："+packetTotal);
			System.out.println(account.name+"账户余额为："+account.money);
			System.out.println("=============================================");
		}
	}
}