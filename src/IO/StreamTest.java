package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class StreamTest {
	public static void main(String[] args) throws IOException {
//		readChar();
//		readChars();
//		write();
//		copy();
//		reader();
//		writer();
//		byteArrayInputStream();
//		byteArrayOutputStream();
		byteArrayToFile(fileToByteArray());
	}
	
	
	//FileInputStream字节流读取字节
	public static void readChar() throws IOException {
		//1. 创建源
		File src = new File("abc.txt");
		
		//2. 选择流
		InputStream in = new FileInputStream(src);
		
		// 3. 操作数据，因为选择的是字节流于，中文编码不是一个字节所以会乱码
		int temp;
		while ((temp = in.read())!= -1) {
			System.out.print((char)temp);
		}
		
		// 4. 释放资源
		in.close();
	}
	
	//FileInputStream多个字节流的读取
	public static void readChars() throws IOException {
		//1. 创建源
		File src = new File("abc.txt");
		
		//2. 选择流
		InputStream in = new FileInputStream(src);
		
		// 3. 分段读取
		byte[] car = new byte[3];
		int len = -1;
		while ((len = in.read(car))!= -1) {
			//字节数组-----》字符串（解码）
//				System.out.println(len);
			String str = new String(car,0,len);
			System.out.print(str);
		}
		in.close();
	}
	
	//FileOutputStream字节流写入
	public static void write() throws IOException {
		//1. 创建流
		File dest = new File("dest.txt");
		
		//2. 选择流
		OutputStream os =  new FileOutputStream(dest,false);//false是覆盖写，true是追加写
		
		//3. 操作，写出内容
		String msg = "IO is so easy";
		byte[] datas = msg.getBytes();
		os.write(datas,0,datas.length);
		os.flush();
		os.close();
	}
	
	//字节流copy文件
	public static void copy() throws IOException {
		//1. 创建源
		File src = new File("pic.png");
		File dest = new File("pic-copy.png");
		
		//2. 选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest,false);//false表示覆盖写
		
	
		//3.  拷贝操作
		byte [] buffer = new byte[1024];
		int len = -1;
		System.out.println("拷贝图片操作");
		
		while((len = is.read(buffer))!= -1) {
			os.write(buffer,0,len);
		}
		os.flush();
		System.out.println("拷贝成功");
		
		//释放资源
		os.close();
		is.close();
	}
	
	//ByteArrayInputStream 字节流读取
	public static void byteArrayInputStream() throws IOException {
		//1. 创建源：字节数组 不要太大
		byte[] src = "talk is cheap show me the code\n大风起兮云飞扬\n".getBytes();
		
		//2. 选择流
		InputStream is = new ByteArrayInputStream(src);
		
		//3. 操作
		byte[] buffer = new byte[5];//缓冲容器
		int len = -1;
		while((len = is.read(buffer))!= -1) {
			//字符数组----》字符串（解码）
			String str = new String(buffer,0,len);
			System.out.print(str);
		}
		//4. 释放资源
		is.close();
	}
	
	/*
	 * 字节数组输出流
	 * 1. 创建源：内部维护
	 * 2. 创建流：不关联源
	 * 3.操作（写出内容）
	 * 4. 释放资源：可以不用
	 */
	public static void byteArrayOutputStream() throws IOException {
		//1. 创建源
		byte[] dest = null;
		
		//2. 选择流（新增方法）
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//没有选择源
		//3. 操作（写出）
		String msg = "show me the code";
		byte[] datas = msg.getBytes();
		baos.write(datas,0,datas.length);
		baos.flush();
		
		// 获取数据
		dest = baos.toByteArray();//ByteArrayOutputStream这个有点特殊，没有选择源，所以在这里把值传递给数据源
		System.out.println(dest.length+"-->"+ new String(dest,0,dest.length));
		baos.close();
	}
	
	/*
	 * 图片到字节数组
	 * 1. 图片到程序：FileInputStream
	 * 2.程序到字节数组：ByteArrayOutStream
	 */
	public static byte[] fileToByteArray() throws IOException {
		//1. 创建源
		File src = new File("pic.png");
		
		//2. 选择流
		InputStream in = new FileInputStream(src);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
		// 3. 操作数据
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len=in.read(buffer))!= -1) {
			baos.write(buffer,0,len);
		}
		baos.flush();
		
		// 4. 释放资源
		baos.close(); //这是一个空方法
		in.close();
		return baos.toByteArray();	
	}
	
	/*
	 * 字节数组到图片
	 * 1. 字节数组写入到程序ByteArrayInputStream
	 * 2. 程序到文件FileOutputStream
	 */
	public static void byteArrayToFile(byte[] datas) throws IOException {
		
		File file = new File("pic-copy.png");
		InputStream is = new ByteArrayInputStream(datas);
		OutputStream os = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = is.read(buffer))!=-1) {
			os.write(buffer,0,len);
		}
		os.flush();
		os.close();
		is.close();
	}
	
	//**************************上面都是文件字节流,下面是文件字符流***********************************************
	//FileReader读取文件
	public static void reader() throws IOException {
		//1. 创建流
		File src = new File("abc.txt");
		
		//2. 选择流
		Reader reader = new FileReader(src);
		char[] buffer = new char[3];
		int len = -1;
		while((len = reader.read(buffer))!= -1) {
			//字符数组---》字符串
			String str = new String(buffer,0,len);
			System.out.print(str);
		}
		reader.close();
	}
	
	//FileWriter写入文件
	public static void writer() throws IOException {
		File dest = new File("dest.txt");
		Writer writer = new FileWriter(dest);//默认false,写覆盖
		
		//写入操作
		String msg = "烈火焚原，寸草不生\n";
		char[] datas = msg.toCharArray();
		writer.write(datas,0,datas.length);//写字符数组
		writer.write(msg);//写字符串
		writer.append(msg).append(msg);
		writer.flush();
		writer.close();
	}
}
