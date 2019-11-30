package zzy3day;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestGeneric {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("你好啊");
		c.add("降妖师");
		c.add("八戒");
		c.size();
		System.out.println(c);
		System.out.println(c.contains("你好啊"));
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);
		list.add(2,"尾生篇");
		System.out.println(list);
		list.set(2,"南国篇");
		System.out.println(list);
		
	}
}