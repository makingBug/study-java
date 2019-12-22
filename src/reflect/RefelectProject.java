package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 需求：写一个“框架”,在不改变该类的任何代码的前提下，帮我们创建任意类的对象，并且执行其中任意方法。
 * 实现：
 * 	1. 配置文件
 * 	2. 反射
 * 步骤：
 * 	1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 	2. 在程序中加载读取配置文件
 * 	3. 使用反射技术来加载类文件进内存
 * 	4. 创建对象
 * 	5. 执行方法
 * 
 * @author zzy
 *
 */
public class RefelectProject {
	public static void main(String[] args) throws Exception {
		RefelectProject r = new RefelectProject();
		r.getIni();
	}
	
	public void getIni() throws Exception {
		//1. 创建Properties对象
		Properties pro = new Properties();
		
		//2. 加载配置文件，转换为一个集合，获取class目录下的配置文件
		//getClass == RefelectProject.class获取类字节码对象------》获取类加载器-----》读取指定资源的输入流
		ClassLoader classLoader = getClass().getClassLoader();
//		ClassLoader classLoader = RefelectProject.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("pro.properties");
		pro.load(is);
		
		//3. 获取配置文件中定义的数据
		String className = pro.getProperty("className");
		String methodName = pro.getProperty("methodName");
		
		// 4. 加载该类进内存
		Class cls = Class.forName(className);
		
		//5. 创建对象
		Object obj = cls.newInstance();
		
		//6. 获取方法对象
		Method method = cls.getMethod(methodName);
		
		//7. 执行方法
		System.out.println(method.invoke(obj));
	}
}
