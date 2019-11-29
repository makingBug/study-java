package zzy2day;

public class TestRAM {
	public static void main(String[] args) {
		long num1 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time1 = System.currentTimeMillis();//获取当前系统时间
		String str = "";
		for (int i = 0;i < 5000;i++){
			str = str + i; //产生了10000个对象
		}
		long num2 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
		long time2 = System.currentTimeMillis();//获取当前系统时间
		System.out.println("String占用内存："+(num1-num2));
		System.out.println("String占用时间："+(time2 - time1));
		
		
		StringBuilder str_build = new StringBuilder("");
		long num3 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time3 = System.currentTimeMillis();//获取当前系统时间
		for(int i=0;i<5000;i++) {
			str_build.append(i);
		}
		long num4 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time4 = System.currentTimeMillis();//获取当前系统时间
		System.out.println("String占用内存："+(num3-num4));
		System.out.println("String占用时间："+(time4 - time3));
	}
}
