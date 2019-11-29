package zzy2day;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getTime());
		
		//时间对象和字符串之间相互转换
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss"); //hh是12小时制
		String s = df.format(new Date());
		System.out.println(s);
		
		//把字符串按照“格式字符串指定的格式”转换成时间的对象
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");//HH是24小时制
		Date date = df2.parse("19950921 12:30:30");
		System.out.println(date);
		System.out.println(date.getTime());
		
		
		//测试日期类的使用
		Calendar calendar = new GregorianCalendar(2999,10,9,22,10,50);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(weekday);
		
	}
	
}
