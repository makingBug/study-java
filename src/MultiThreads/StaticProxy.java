package MultiThreads;

/*
 * 静态代理
 * 公共接口：
 * 1. 真实角色
 * 2. 代理角色
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new Couple("范闲","林婉儿")).happyMarry();
	}
}

interface Marry{
	void happyMarry();//闹婚庆
} 

class Couple implements Marry{
	String husband,wife;
	
	public Couple(String husband,String wife) {
		this.husband = husband;
		this.wife = wife;
	}
	
	@Override
	public void happyMarry() {
		System.out.println("祝福 "+husband+" 和 "+wife+" 这对新人新婚快乐");
		
	}
}


class WeddingCompany implements Marry{
	//真实角色
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target = target;
	}
	@Override
	public void happyMarry() {
		banquet();
		this.target.happyMarry();
		game();
	}
	
	public void banquet() {
		System.out.println("高朋满座，把酒林欢，开吃");
	}
	public void game() {
		System.out.println("该入洞房了，嗯，问题不大");
	}	
}