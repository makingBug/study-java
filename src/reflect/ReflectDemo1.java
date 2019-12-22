package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

/**
 * 	
 * 
 * @author zzy
 *
 */

public class ReflectDemo1 {
	public static void main(String[] args) throws Exception {
		ReflectDemo1 r = new ReflectDemo1();
		r.getClassByte();
		r.getMemberVariables();
		r.getConsructor();
		r.getMethod();
		r.getClassName();
	}
	
	
	
	/**
	 * 
	 * 	获取Class对象的方式：
	 * 		1. Class.forName("全类名")：将字节码文件加载进内存，返回class对象
	 * 		2. 类名.class：通过类名的属性class获取
	 * 		3. 对象.getClass()：getClass()方法在Object类中定义着
	 * @return 
	 * @throws Exception 
	 * 
	 */
	@Test
	public void getClassByte() throws Exception {
		System.out.println("===========================获取Class对象===================================");
		// 1. Class.forName("全类名")
		Class c1 = Class.forName("reflect.Person");
		System.out.println(c1);
		
		// 2. 类名.class
		Class c2 = Person.class;
		System.out.println(c2);
		
		// 3. 对象.getClass()
		Person p = new Person("名字",18);
		Class c3 = p.getClass();
		System.out.println(c3);
		
		System.out.println(c1 == c2);
		System.out.println(c2 == c3);
	}
	
	/**
	 * 	获取成员变量
	 * @throws  
	 * @throws NoSuchFieldException 
	 */
	@Test
	public void getMemberVariables() throws Exception{
		System.out.println("===========================获取成员变量===================================");
		//1. 获取Person的Class对象
		Class personClass = Person.class;
		Person p = new Person("爱新觉罗-福临",24);
		
		//该方法是获取类中所有public的变量
		System.out.println("=====getFields获取所有public变量");
		Field[] fields = personClass.getFields();
		for (Field f:fields) {
//			System.out.println(f);
			System.out.println(f.getName());
		}
		
		//获取某个变量，对其赋值，取值
		//获取变量列变量a的Field对象
		System.out.println("=====get,set一个变量的值");
		Field id = personClass.getField("id");
		Object value = id.get(p);
		System.out.println("value = "+value);
		System.out.println("p.id = "+p.id);
		System.out.println("id = " + id);
		id.set(p, 100);
		System.out.println(p);
		
		
		//获取所有的成员变量，不考虑访问权限修饰符
		System.out.println("=====getDeclaredFields获取所有的变量");
		Field[] declaredFields = personClass.getDeclaredFields();
		for(Field declaredField : declaredFields) {
			System.out.println(declaredField.getName());
		}
		
		System.out.println("=====get，set一个private变量的值");
		Field name = personClass.getDeclaredField("name");
		//忽略访问权限修饰符的安全检查
		name.setAccessible(true);//暴力反射
		Object value2 = name.get(p);
		System.out.println("p.name = "+value2);
		name.set(p, "爱新觉罗-努尔哈赤");
		Object value3 = name.get(p);
		System.out.println("p.name = "+value3);
	}
	
	/**
	 * 	获取构造方法，目的就是创建对象
	 * @throws SecurityException 
	 * @throws  
	 */
	@Test
	public void getConsructor() throws Exception {
		System.out.println("===========================获取构造方法===================================");
		Class personClass = Person.class;
		//获取构造方法，用来创建对象用的
		Constructor constructor =  personClass.getConstructor(String.class,int.class);
		System.out.println(constructor);
		Object p1 = constructor.newInstance("爱新觉罗-玄烨",8);
		System.out.println("新创建对象1：" +p1);
		Constructor constructor1 =  personClass.getConstructor();
		Object p2 = constructor1.newInstance();
		System.out.println("新创建对象2："+p2);
		
		
		Object o = personClass.newInstance();//class方法中提供了创建对象的函数，但是只能空参构造，如果需要给构造函数传参需要使用上面的方式
		System.out.println("新创建对象3：" + o);
	}
	
	/**
	 * 	获取成员方法，目的是为了执行方法
	 * @throws Exception 
	 */
	@Test
	public void getMethod() throws Exception {
		System.out.println("===========================获取成员方法===================================");
		Class personClass = Person.class;
		Person p = new Person("爱新觉罗-溥仪",56);
		//获取指定名称的方法
		System.out.println("=====获取eat方法并执行");
		Method eat = personClass.getMethod("eat");
		eat.invoke(p);
		
		System.out.println("=====获取含参数的eat方法并执行");
		Method eat_food = personClass.getMethod("eat", String.class);
		eat_food.invoke(p, "饭菜");
		
		//获取所有public修饰的方法，包括继承的
		System.out.println("=====获取all public方法，包含继承");
		for(Method method:personClass.getMethods()) {
//			System.out.println(method);
			System.out.println(method.getName());
		}
		
		System.out.println("=====获取类内all方法，不包含继承");
		//该方法获取类中所有声明的方法(任何权限的),但是不包括继承的方法
		for (Method method: personClass.getDeclaredMethods()) {
//			System.out.println(method);
			System.out.println(method.getName());
		}
	}
	
	/**
	 * 
	 * 
	 */
	@Test
	public void getClassName(){
		//获取类名：
		System.out.println("===========================获取类名===================================");
		Class personClass = Person.class;
		String className = personClass.getName();
		System.out.println(className);
	}
}
