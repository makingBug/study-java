package zzy1day;

import java.io.FileReader;
import java.io.IOException;

public class TestExceptionAnthor {
	public static void main(String[] argv) throws IOException {
		FileReader reader = new FileReader("f:/javatest.txt");
		char c1 = (char)reader.read();
		System.out.println(c1);
		
		if(reader != null) {
			reader.close();
		}
	}
}
