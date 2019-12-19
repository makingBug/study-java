package MultiThreads;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

/*
 * 创建线程的方式三
 * 采用Callable方式：重写call方法
 * 1. call可以有返回值，2. 可以抛异常
 */
public class CreateThreadCallable implements Callable<Boolean>{

	String url;//远程路径
	String name;//存储名字
	public CreateThreadCallable(String url,String name) {
		this.url = url;
		this.name = name;
	}
	
	@Override
	public Boolean call() throws Exception {
		download(url, name);
		System.out.println(name);
		return true;
	}
	
	public void download(String url,String name)  {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			System.out.println("不合法的url");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("图片下载失败");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CreateThreadCallable cd1 = new CreateThreadCallable("https://inews.gtimg.com/newsapp_bt/0/6887886759/640", "td1.jpg");
		CreateThreadCallable cd2 = new CreateThreadCallable("https://inews.gtimg.com/newsapp_bt/0/6949141757/640", "td2.jpg");
		CreateThreadCallable cd3 = new CreateThreadCallable("https://inews.gtimg.com/newsapp_bt/0/6949148150/640", "td3.jpg");
		//1. 创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(3);
		//2. 提交执行
		Future<Boolean> result1 = ser.submit(cd1);
		Future<Boolean> result2 = ser.submit(cd2);
		Future<Boolean> result3 = ser.submit(cd3);
		
		//3. 获取结果
		System.out.println(result1.get());
		System.out.println(result2.get());
		System.out.println(result3.get());
		
		
		//4. 关闭服务
		ser.shutdownNow();
		
	}

	

}
