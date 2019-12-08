package zzy4day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestIterator {
	public static void main(String[] args) {
		testIteratorList();
		testIteratorSet();
		testIteratorMap();
	}
	
	//遍历list
	public static void testIteratorList() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		
		for(Iterator<String> it = list.iterator();it.hasNext();) {
			String temp = it.next();
			System.out.println(temp);
		}
	}
	
	//b遍历set
	public static void testIteratorSet() {
		Set<String> set = new HashSet<String>();
		set.add("set2");
		set.add("set1");
		set.add("set3");
		
		for(Iterator<String> it = set.iterator();it.hasNext();) {
			String temp = it.next();
			System.out.println(temp);
		}
	}
	
	//遍历map
	public static void testIteratorMap() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(2, "你好呀");
		map.put(3, "降妖师");
		map.put(1,"四代目");
		
		//一种遍历方式
		Set<Entry<Integer,String>> s = map.entrySet();
		for (Iterator<Entry<Integer,String>> it = s.iterator();it.hasNext();) {
			Entry<Integer,String>temp = it.next();
			System.out.println(temp.getKey()+"----"+temp.getValue());
		}
		
		//第二种遍历方式
		System.out.println("--------------------------------");
		Set<Integer> keySet = map.keySet();
		for (Iterator<Integer> it = keySet.iterator();it.hasNext();) {
			Integer key = it.next();
			System.out.println(key+"----"+map.get(key));
		}
		
		
	}
}
