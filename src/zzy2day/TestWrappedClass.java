package zzy2day;

public class TestWrappedClass {
	public static void main(String[] args) {
		//基本数据类型转换成包装类对象
		Integer a = new Integer(3);
		Integer b = Integer.valueOf(30);
		
		//把包装类转换成基本数据类型
		int c = b.intValue();
		double d = b.doubleValue();
		
		//把字符串转换成包装类对象
		Integer e = new Integer("999");
		System.out.println(e);
		
		//常见的常量
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		//缓存[-128,127]之间的数字
		Integer i1 = 123;
		Integer i2 = Integer.valueOf(123);
		System.out.println(i1 == i2); //返回true用了缓存
		System.out.println(i1.equals(i2));
		
		
		Integer i3 = 1234;
		Integer i4 = 1234;
		System.out.println(i3 == i4); //返回true用了缓存
		System.out.println(i3.equals(i4));
		
		
	}
}
