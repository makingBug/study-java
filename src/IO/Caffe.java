package IO;

/*
 * 模拟咖啡
 * 1. 抽象组件:需要装饰的抽象对象（接口或抽象父类）
 * 2. 具体组件:需要装饰的对象
 * 3. 抽象装饰类:包含了对抽象组件的引用以及装饰着共有的方法
 * 4. 具体装饰类:被装饰的对象
 * 
 */
public class Caffe {
	public static void main(String[] args) {
		Drink coffee = new Coffe();
		Drink suger = new Suger(coffee);
		System.out.println(suger.info()+"--->"+suger.cost());
		Drink milk = new Milk(coffee);
		System.out.println(milk.info()+"--->"+milk.cost());
		milk = new Milk(suger);
		System.out.println(milk.info()+"--->"+milk.cost());
	}
}

//抽象组件
interface Drink{
	double cost();//费用
	String info();//说明
}

//具体组件
class Coffe implements Drink{
	private String name = "原味咖啡";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
}

// 抽象装饰类
abstract class Decorate implements Drink{
	//对抽象组件的引用
	private Drink drink;
	
	public Decorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
}

//具体装饰类
class Milk extends Decorate{

	public Milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了牛奶";
	}
}

//具体装饰类
class Suger extends Decorate{

	public Suger(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*2;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了糖";
	}
}