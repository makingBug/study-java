package reflect;

public class Person {
	private String name;
	private int age;
	public String describtion = "你好呀";
	public int id = 10;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	public void eat() {
		System.out.println("eat方法...");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", describtion=" + describtion + ", id=" + id + "]";
	}

	public void eat(String food) {
		System.out.println("含参数的eat方法..."+food);
	}
	public void sleep() {
		System.out.println("sleep方法...");
	}
}
