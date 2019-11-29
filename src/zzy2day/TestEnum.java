package zzy2day;

public class TestEnum {
	public static void main(String[] args) {
		Season a = Season.AUTUMN;
		switch(a) {
		case SPRING:
			System.out.println("春天来了");break;
		case SUMMER:
			System.out.println("夏天来了");break;
		case AUTUMN:
			System.out.println("秋天来了");break;
		case WINTER:
			System.out.println("冬天来了");break;
		}
		System.out.println(Season.AUTUMN);
	}
}

enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}