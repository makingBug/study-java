package zzy1day;
import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		int[] arr01 = new int[10];//数组的声明
		Users[] arr02 = new Users[10];
		
		arr02[0]= new Users(1001,"你好呀，降妖师");//数组中存放的是对象的应用，实际需要创建对象执行对象的引用
		
		//另外一种初始化的方式
		int[] a = {1,2,3};
		Users[] b = {
				new Users(1002,"zzy"),
				new Users(1003,"mcu")
				};
		
		
		//数组的拷贝System.arraycopy
		String[] s1 = {"aa","bb","cc","dd","ee"};
		String[] s2 = new String[10];
		System.arraycopy(s1, 2, s2, 3, 2);
		for(String s:s2) {
			System.out.println(s);
		}
		
		// 测试java.util.Arrays，这是一个操作数组的类；
		int []c = {10,20,30,5,3,100,85};
		System.out.println(c);
		System.out.println(Arrays.toString(c));
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.binarySearch(c, 30)); //二分查找
		
	}
}

class Users{
	private int id;
	private String name;
	
	public Users(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
