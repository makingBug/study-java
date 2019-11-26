package zzy1day;

public class TestEquals {
	public static void main(String[] argv) {
		User u1 = new User(1000,"张某人","123456");
		User u2 = new User(1000,"王某人","123456");
		System.out.println(u1==u2);
		System.out.println(u1.equals(u2));
		
		String s1 = "sxt";
		String s2 = new String("sxt");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}
}

class User{
	int id;
	String name;
	String pwd;
	
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
