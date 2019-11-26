package zzy1day;

public class Welcome {
	public static void main(String[] args) {
		Student s = new Student("makingBug",20,"coding");
		System.out.println(s.toString());
		
	}
}

class Person {
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会");
    }  
}
class Student extends Person {
    String major; //
    public void study(){
        System.out.println("学习java");
    }  
    public Student(String name,int height,String major) {
        this.name = name;
        this.height = height;
        this.major = major;
    }
    
    @Override
    public String toString() {
    	return "name:"+name+"\n"+"height:"+height+"\n"+"major:"+major+"\n";
    }
}
