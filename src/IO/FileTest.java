package IO;

import java.io.File;

/*
 * 获取文件的基本信息
 * File的使用
 */
public class FileTest {
	public static void main(String[] args) {
		message();
	}
	//File获取文件或目录的一些基本信息
	public static void message() {
		String path =  "C:/Users/zzy/Pictures/your names/1.png";
		
		//创建对象的两种方式
		File file = new File(path);
		System.out.println("文件大小："+file.length()); //返回文件的长度，单位是字节B
		
		File dir = new File("C:/Users/zzy/Pictures/your names");
		System.out.println("目录大小："+dir.length()); 
		
		System.out.println("文件的绝对路径："+file.getAbsolutePath());//获取绝对路径
		System.out.println("当前工作路径："+System.getProperty("user.dir")); //当前工作目录的路径
		
		System.out.println("文件的名字："+file.getName());//获取文件或者目录的名字
		System.out.println("目录的名字："+dir.getName());
		
		System.out.println("文件的父目录："+file.getParent());//获取父目录，如果没有返回null
		System.out.println("目录的父目录："+dir.getParent());
		
		System.out.println("文件的路径："+file.getPath());//这个获取到的不是绝对路径，是File中传入的那个参数
		System.out.println("目录的路径："+dir.getPath());
	}
}
