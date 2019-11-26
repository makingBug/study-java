package zzy1day;

public class TestString {
	
	public static void main(String[] argv) {
		String s1 = new String("  java  core  ");
		String s2 = new String("  Java  Core  ");
		
		System.out.println(s1.charAt(2));//下标为2字符
		System.out.println(s2.length());//字符串长度
		System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写比较
		System.out.println(s1.indexOf("core"));//字符串s1中是否包含“core”，返回其实下标
		
		String s = s1.replace("  ", "&");//字符串替换，因为String是不可变对象，所以会生成一个新的对象
		System.out.println(s);
		
		System.out.println(s1.startsWith("java")); //s1是否以“java”字符串开头
		System.out.println(s1.endsWith("Core")); // s1是否以“java”字符串结尾
		
		s = s1.substring(1,2); //截取字符串，前闭后开区间 [ )
		System.out.println(s);
		
		s = s1.substring(1); //截取字符串,第二个参数不写,默认截取到最后
		System.out.println(s);
		
		s = s2.toLowerCase();//字符串转换成小写字符
		System.out.println(s);
		
		s = s1.toUpperCase(); //字符串转换成大写字母
		System.out.println(s);
		
		s = s1.trim();//去除字母首尾空格，中间的空格不管
		System.out.println(s);
	}
	
}
