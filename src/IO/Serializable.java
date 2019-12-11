package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializable {
	private static ObjectOutputStream os;
	private static ObjectInputStream is;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student student = new Student("zzy",12);
		
		//----------------------序列化操作---------------------------------------
		//1.2 选择流;选择源
		os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("serializable.txt"))));
		
		// 3. 操作数据类型+数据
		os.writeUTF("编码辛酸泪");
		os.writeInt(18);
		os.writeBoolean(false);
		os.writeChar('a');
		//对象
		os.writeObject("谁解其中味");//String对象
		os.writeObject(student);
		os.flush();
		
		//4. 关闭资源
		os.close();
	
		//1.2 选择流;选择源
		is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("serializable.txt"))));
		
		// 3. 操作数据类型+数据
		System.out.println(is.readUTF());
		System.out.println(is.readInt());
		System.out.println(is.readBoolean());
		System.out.println(is.readChar());
		System.out.println(is.readObject());
		System.out.println(is.readObject());

		//4. 关闭资源
		is.close();
	}
}

class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[name:"+this.name+";"+"age:"+this.age+"]");
		return s.toString();
	}
}
