package zzy3day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		int num = 50000;
		long ram1 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time1 = System.currentTimeMillis();//获取当前系统时间
		Map<Integer,String> map = new HashMap<Integer, String>();
		for (int i = 0;i<num;i++) {
			map.put(i, "zzy");
		}
		for (int i =0;i<num;i++) {
			map.get(i);
		}
		long ram2 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time2 = System.currentTimeMillis();//获取当前系统时间
		System.out.println("哈希表用时："+(time2-time1)+"ms");
		System.out.println("哈希表消耗："+(ram1-ram2)/1024/1024+"M");
		
		
		long ram3 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time3 = System.currentTimeMillis();//获取当前系统时间
		List<String> list = new LinkedList<String>();
		for (int i = 0;i<num;i++) {
			list.add("zzy");
		}
		for (int i =0;i<num;i++) {
			list.get(i);
		}
		long ram4 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time4 = System.currentTimeMillis();//获取当前系统时间
		System.out.println("链表用时："+(time4-time3)+"ms");
		System.out.println("链表消耗："+(ram3-ram4)/1024/1024+"M");
		
		
		long ram5 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time5 = System.currentTimeMillis();//获取当前系统时间
		List<String> array = new ArrayList<String>();
		for (int i = 0;i<num;i++) {
			array.add("zzy");
		}
		for (int i =0;i<num;i++) {
			array.get(i);
		}
		long ram6 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
		long time6 = System.currentTimeMillis();//获取当前系统时间
		System.out.println("动态数组用时："+(time6-time5)+"ms");
		System.out.println("动态数组消耗："+(ram5-ram6)/1024/1024+"M");
		
	}
}

