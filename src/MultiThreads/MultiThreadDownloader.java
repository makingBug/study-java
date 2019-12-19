package MultiThreads;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;


public class MultiThreadDownloader implements Runnable{
	String url;//远程路径
	String name;//存储名字
	public MultiThreadDownloader(String url,String name) {
		this.url = url;
		this.name = name;
	}
	
	@Override
	public void run() {
		download(url, name);
		System.out.println(name);
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
	public static void main(String[] args) {
		Thread td1 = new Thread(new MultiThreadDownloader("https://inews.gtimg.com/newsapp_bt/0/6887886759/640", "td1.jpg"));
		Thread td2 = new Thread(new MultiThreadDownloader("https://inews.gtimg.com/newsapp_bt/0/6949141757/640", "td2.jpg"));
		Thread td3 = new Thread(new MultiThreadDownloader("https://inews.gtimg.com/newsapp_bt/0/6949148150/640", "td3.jpg"));
		
		//启动三个线程
		td1.start();
		td3.start();
		td2.start();
	}
}