package zzy1day;

/*
 * 测试多态
 * @author zzy
 *
 * 
 */

public class TestPolym {
	public static void main(String[] argv) {
		Animal dog_a = new Dog();
		Animal cat_a = new Cat();
		
		dog_a.shout();
		cat_a.shout();
		
		animalCry(dog_a);
		animalCry(cat_a);
	}
	
	static void animalCry(Animal a) {
		a.shout();
	}
	
}


class Animal{
	public void shout() {
		System.out.println("动物叫了一声");
	}
}

class Dog extends Animal{
	public void shout() {
		System.out.println("小狗叫了一声");
	}
}

class Cat extends Animal{
	public void shout() {
		System.out.println("小猫叫了一声");
	}
}