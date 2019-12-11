package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

//BufferedInputStream和BufferedOutputStream的测试
public class TestBuffer {
	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();
		buffer_copy();
		long t2 = System.currentTimeMillis();
		copy();
		long t3 = System.currentTimeMillis();
		System.out.println("加入缓存的执行时间："+(t2-t1)+"ms");
		System.out.println("没有加入缓存的执行时间："+(t3-t2)+"ms");
		
		convert();
		
	}
	
	public static void buffer_copy() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(new File("pic.png")));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(new File("pic-buffer.png")));
		byte[]buffer = new byte[1024];
		int len = -1;
		while((len = is.read(buffer))!=-1) {
			os.write(buffer,0,len);
		}
		os.flush();
		os.close();
		is.close();
	}
	
	public static void copy() throws IOException {
		InputStream is = new FileInputStream(new File("pic.png"));
		OutputStream os = new FileOutputStream(new File("pic-copy.png"));
		byte[]buffer = new byte[1024];
		int len = -1;
		while((len = is.read(buffer))!=-1) {
			os.write(buffer,0,len);
		}
		os.flush();
		os.close();
		is.close();
	}
	
	/*
	 * 转换流：InputStreamReader和OutputStreamWriter
	 * 1. 以字符流的形式操作字节流
	 * 2. 指定字符集
	 */
	public static void convert() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out,"UTF-8"));
		String msg = "";
		while(!msg.equals("exit")) {
			msg = reader.readLine();
			writer.write(msg);
			writer.newLine();
			writer.flush();
		}
		writer.close();
		reader.close();
	}
}
