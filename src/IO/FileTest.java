package IO;

import java.io.File;
import java.io.IOException;

/*
 * 获取文件的基本信息
 * File的使用
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
		message();
		System.out.println("=====================================================");
		status();
		System.out.println("=====================================================");
		createFile();
		System.out.println("=====================================================");
		createDir();
		System.out.println("=====================================================");
		list();
		System.out.println("=====================================================");
		countDir();
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
	
	//File获取状态
	public static void status(){
		String path =  "C:/Users/zzy/Pictures/your names/1.png";
		//创建对象的两种方式
		File file = new File(path);
		File dir = new File(new File("f:/"),"");
		
		System.out.println("1.png是否存在："+file.exists());
		System.out.println("your names是否存在："+dir.exists());
		
		System.out.println("1.png是否是文件："+file.isFile());
		System.out.println("your names是否是目录："+dir.isDirectory());
	}
	
	//File创建删除文件
	public static void createFile() throws IOException {
		String path =  "C:/Users/zzy/Pictures/your names/my.png";
		File file = new File(path);
		boolean flag = file.createNewFile(); //只能用来创建文件，且文件存在就会创建失败
		System.out.println("创建文件是否成功："+flag);
		
		flag = file.delete();//删除创建的文件
		System.out.println("删除文件是否成功："+flag);
	}
	
	//创建和删除目录
	public static void createDir() {
		String path =  "C:/Users/zzy/Pictures/your names/dir1/dir2/dir3";
		File file = new File(path);
		boolean flag = file.mkdirs(); //创建目录有mkdir和mkdirs;mkidrs如果创建目录的上级目录不存在会一起创建
		System.out.println("创建目录成功："+flag);
		
		System.out.println(file.delete()); //删除dir3
		file = file.getParentFile();
		
		System.out.println(file.delete()); //删除dir2
		file = file.getParentFile();
		
		System.out.println(file.delete()); //删除dir1
		file = file.getParentFile();
	}
	
	//目录的遍历
	public static void list() {
		String path =  "C:/Users/zzy/Pictures/your names/";
		File file = new File(path);
		
		//list()列出的该目录下文件和目录的名称，返回值String[],如果file传入的不是文件，返回null
		for (String f:file.list()) {
			System.out.println("文件名："+f);
		}
		
		//listFiles()列出该目录文件和目录的对象，返回值file[]如果file传入的不是文件，返回null
		for (File f: file.listFiles()) {
			System.out.println("绝对路径："+f.getAbsolutePath());
		}
		
		//列出所有的盘符,不常用
//		for (File f: File.listRoots()) {
//			System.out.println(f.getName());
//		}
	}
	
	//统计文件夹的大小,采用递归遍历
		static long countDir = 0;
		static long sizeFile = 0;
		public static void countDir() {
			String path =  "C:/Users/zzy/Pictures";
			File file = new File(path);
			sizeFile = 0;
			countDir = 0;
			helper(file);
			System.out.println("文件夹大小："+sizeFile+"B");
			System.out.println("文件夹大小："+countDir+"个");//算自己本身
			
		}
		public static void helper(File f) {
			countDir += 1;
			for (File file:f.listFiles()) {
				if(file.isFile()) {
					sizeFile += file.length();
				}else {
					helper(file);
				}
			}
		}
	
}
