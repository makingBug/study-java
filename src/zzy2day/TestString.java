package zzy2day;

/*
 * 测试StringBuilder、StringBuffer
 * 
 */
public class TestString {
	public static void main(String[] args) {
		//StringBuilder线程不安全，效率高；StringBuffer线程安全，效率低
		StringBuilder buffer = new StringBuilder("abcdefg");
		System.out.println(Integer.toHexString(buffer.hashCode()));
		System.out.println(buffer);
		buffer.setCharAt(2, 'z');
		System.out.println(Integer.toHexString(buffer.hashCode()));
		System.out.println(buffer);
		System.out.println(buffer.indexOf("bz"));
		
		
		StringBuilder sb = new StringBuilder();
		for (int i= 0;i<26;i++) {
			char temp = (char) ('a'+i);
			sb.append(temp);//尾插字符
		}
		System.out.println(sb);
		
		sb.reverse();//字符串倒序
		System.out.println(sb);
		
		sb.insert(1, '张').insert(1, '忠').insert(1, '义'); //链式调用，因为方法返回了this
		System.out.println(sb);
		
		sb.delete(0, 10).delete(0, 10);
		System.out.println(sb);
		System.out.println(sb.length());
		
	}
}
