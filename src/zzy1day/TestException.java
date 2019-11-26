package zzy1day;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//异常处理try catch语句
public class TestException {
	public static void main(String[] argv) {
		FileReader reader = null;
		try {
			System.out.println("step1");
			reader = new FileReader("f:/javatest.txt");
			char c1 = (char)reader.read();
			System.out.println(c1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("step2");
			e.printStackTrace();
			System.out.println("没有文件README.md");
		} catch (IOException e) {
			System.out.println("step3");
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("去读文件异常");
		}finally {
				try {
					System.out.println("step4");
					if (reader!=null) {
						System.out.println("step5");
						reader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("step6");
				}
			}
		}
	}
