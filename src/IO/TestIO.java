package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class TestIO {
	public static void main(String[] args) throws IOException {
//		readChar();
//		readChars();
//		write();
		copy();
	}
	
	public static void readChar() throws IOException {
		//1. 创建源
		File src = new File("abc.txt");
		
		//2. 选择流
		InputStream in = null;
		try {
			in = new FileInputStream(src);
			// 3. 操作数据
			int temp;
			while ((temp = in.read())!= -1) {
				System.out.print((char)temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4. 释放资源
			if(in != null) {
				in.close();
			}
		}
	}
	
	public static void readChars() throws IOException {
		//1. 创建源
		File src = new File("abc.txt");
		
		//2. 选择流
		InputStream in = null;
		try {
			in = new FileInputStream(src);
			// 3. 分段读取
			byte[] car = new byte[3];
			int len = -1;
			while ((len = in.read(car))!= -1) {
				//字节数组-----》字符串（解码）
//				System.out.println(len);
				String str = new String(car,0,len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4. 释放资源
			if(in != null) {
				in.close();
			}
		}
	}
	
	public static void write() throws IOException {
		//1. 创建流
		File dest = new File("dest.txt");
		
		//2. 选择流
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest,false);//false是覆盖写，true是追加写
			//3. 操作，写出内容
			String msg = "IO is so easy";
			byte[] datas = msg.getBytes();
			os.write(datas,0,datas.length);
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(os != null) {
				os.close();
			}
		}
	}
	
	public static void copy() throws IOException {
		File src = new File("C:\\Users\\zzy\\Pictures\\your names\\1.png");
		File dest = new File("abc.copy.png");
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest,true);
			// 拷贝操作
			byte [] buffer = new byte[1024];
			int len = -1;
			System.out.println("拷贝图片操作");
			while((len = is.read(buffer))!= -1) {
				os.write(buffer,0,len);
			}
			os.flush();
			System.out.println("拷贝成功");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(os != null) {
				os.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}
}
