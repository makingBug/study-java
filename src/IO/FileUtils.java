package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	public static void main(String[] args) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		
		//-------------------流对接测试----------------------------------------
		//FileInputStream--->FileOutputStream,文件复制
		
		is = new FileInputStream("text.txt");
		os = new FileOutputStream("text-copy.txt");
		copyBuffer(is,os);
		
		
		//FileInputStream--->ByteArrayOutputStream;文件到字节数组
		
		byte[] datas = null;
		is = new FileInputStream("text.txt");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		copy(is,bos);
		datas = bos.toByteArray();
		System.out.println(datas.length);
		
		//ByteArrayInputStream--->FileOutputStream: 字节数组到文件
		
		is = new ByteArrayInputStream(datas);
		os = new FileOutputStream("text-byteArray.txt");
		copy(is,os);
		System.out.println("copy success");
			
		
		
		//buffer流和字节流的性能对比
		System.out.println("-----------------性能测试-------------------------------");
		is = new FileInputStream(new File("pic.png"));
		os = new FileOutputStream(new File("pic-buffer.wmv"));
		long t1 = System.currentTimeMillis();
		copyBuffer(is,os);
		long t2 = System.currentTimeMillis();
		
		is = new FileInputStream(new File("pic.png"));
		os = new FileOutputStream(new File("pic-copy.png"));
		long t3 = System.currentTimeMillis();
		copy(is,os);
		long t4 = System.currentTimeMillis();
		System.out.println("Buffer流copy时间："+(t2-t1)+"ms");
		System.out.println("字节流copy时间："+(t4-t3)+"ms");
		
	}
	
	/*
	 * 对接输入输出流
	 */
	public static void copy(InputStream is,OutputStream os) throws IOException{
			
		byte[] buffer = new byte[1024];
		int len = -1;
		
		while((len = is.read(buffer))!=-1) {
			os.write(buffer,0,len);
		}
		os.flush();
		close(is,os);
	}
	
	public static void copyBuffer(InputStream is,OutputStream os) throws IOException {
		byte[] buffer = new byte[1024];
		InputStream bis = new BufferedInputStream(is);
		OutputStream bos = new BufferedOutputStream(os);
		int len = -1;
		
		while((len = bis.read(buffer))!=-1) {
			bos.write(buffer,0,len);
		}
		os.flush();
	 
		bos.close();
		bis.close();
	}
	/*
	 * 关闭资源
	 * ... 可变参数
	 */
	public static void close(Closeable... ios) throws IOException {
		for (Closeable io:ios) {
			if(io != null) {
				io.close();
			}
		}
	}
	
}
