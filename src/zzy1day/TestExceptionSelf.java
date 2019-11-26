package zzy1day;


public class TestExceptionSelf {
	public static void main(String[] args) {
		People p = new People();
		p.setAge(10);
	}
}

class People {
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalAgeException("年龄发生异常");
		}
	}
}

class IllegalAgeException extends RuntimeException{
	public IllegalAgeException() {
		
	}
	public IllegalAgeException(String msg) {
		super(msg);
	}
}
