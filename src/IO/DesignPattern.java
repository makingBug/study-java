package IO;

/*
 * 设计模式
 * 放大器模拟人的声音
 */


public class DesignPattern {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		Amplifier am = new Amplifier(p);
		am.say();
	}
}

interface Say{
	void say();
}

class Person implements Say{
	private int voice = 10;

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("人的声音为："+this.getVoice());
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
}

class Amplifier implements Say{
	private Person p;
	
	public Amplifier(Person p) {
		super();
		this.p = p;
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("人的声音："+p.getVoice()*100);
		System.out.println("噪音");
	}
	
}