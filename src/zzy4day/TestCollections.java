package zzy4day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 更多操作参见Collections类
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i=0;i<10;i++) {
			list.add(""+i);
		}
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.sort(list); //按递增排序，如果是自定义的类则按Comparable接口排序
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "3"));
		
		Collections.shuffle(list); //随机排列集合的元素
		System.out.println(list);
	}
}
