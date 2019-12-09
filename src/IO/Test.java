package IO;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		
//		message();
//		status();
//		createFile();
//		createDir();
//		list();
		countDir();		
	}
	
	//api获取一些基本信息
	public static void message() {
		String path =  "C:/Users/zzy/Pictures/your names/1.png";
		//创建对象的两种方式
		File file = new File(path);
		System.out.println(file.length()); //返回文件的长度，单位是字节B
		
		File dir = new File(new File("f:/"),"");
		System.out.println(dir.length()); 
		
		System.out.println(file.getAbsolutePath());//获取绝对路径
		System.out.println(System.getProperty("user.dir")); //当前工作目录的路径
		
		System.out.println(file.getName());//获取文件或者目录的名字
		System.out.println(dir.getName());
		
		System.out.println(file.getParent());//获取父目录，如果没有返回null
		System.out.println(dir.getParent());
		
		System.out.println(file.getPath());
		System.out.println(dir.getPath());
	}
	
	//api获取状态
	public static void status(){
		String path =  "C:/Users/zzy/Pictures/your names/1.png";
		//创建对象的两种方式
		File file = new File(path);
		File dir = new File(new File("f:/"),"");
		
		System.out.println("是否存在："+file.exists());
		System.out.println("是否存在："+dir.exists());
		
		System.out.println("是否是文件："+file.isFile());
		System.out.println("是否是目录："+dir.isDirectory());
	}
	
	public static void createFile() throws IOException {
		String path =  "C:/Users/zzy/Pictures/your names/2.png";
		File file = new File(path);
		boolean flag = file.createNewFile(); //只能用来创建文件，且文件存在就会创建失败
		System.out.println("创建成功否："+flag);
		
		flag = file.delete();//删除创建的文件
		System.out.println("删除成功否："+flag);
	}
	
	public static void createDir() {
		String path =  "C:/Users/zzy/Pictures/your names/测试目录/下一层目录/再下一层目录";
		File file = new File(path);
		boolean flag = file.mkdirs(); //创建目录有mkdir和mkdirs;mkidrs如果创建目录的上级目录不存在会一起创建
		System.out.println("创建目录成功："+flag);
		file = file.getParentFile().getParentFile();
		System.out.println(file.getAbsolutePath());
		flag = file.delete();
		System.out.println("删除目录成功："+flag);
	}
	
	public static void list() {
		String path =  "C:/Users/zzy/Pictures/your names";
		File file = new File(path);
		
		//list()列出的该目录下文件和目录的名称，返回值String[]
		for (String f:file.list()) {
			System.out.println(f);
		}
		
		//listFiles()列出该目录文件和目录的对象，返回值file[]
		for (File f: file.listFiles()) {
			System.out.println(f.getAbsolutePath());
		}
		
		//列出所有的盘符,了解即可，不常用
		for (File f: file.listRoots()) {
			System.out.println(f.getAbsolutePath());
		}
	}
	
	//统计文件夹的大小
	static long countDir = 0;
	static long sizeFile = 0;
	public static void countDir() {
		String path =  "C:\\Users\\zzy\\Pictures";
		File file = new File(path);
		sizeFile = 0;
		countDir = 0;
		helper(file);
		System.out.println("文件夹大小："+sizeFile+"B");
		System.out.println("文件夹大小："+countDir+"个");
		
	}
	public static void helper(File f) {
//		count += f.length();
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
