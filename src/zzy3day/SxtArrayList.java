package zzy3day;

//实现简单的ArrayList
public class SxtArrayList<E> {
	
	public static void main(String[] args) {
		SxtArrayList<String> s= new SxtArrayList<String>();
		for (int i = 0;i<2;i++) {
			s.add(""+i);
		}
		System.out.println(s);
		
		s.remove(0);
		System.out.println(s);
		System.out.println(s.isEmpty());
		
		s.remove(0);
		System.out.println(s);
		System.out.println(s.isEmpty());
		
		
	}
	private Object[] elementData;
	private int size = 0;
	private static final int DEFALT_CAPACITY = 10;
	
	public SxtArrayList() {
		elementData = new Object[DEFALT_CAPACITY];
	}
	public SxtArrayList(int capacity) {
		elementData = new Object[capacity];
	}
	
	//add方法含有数组扩容，每次扩容1.5倍
	public void add(E e) {
		if(size == this.elementData.length) {
			//
			Object[] newArray = new Object[this.elementData.length + (this.elementData.length>>1)];
			System.arraycopy(this.elementData,0 ,newArray,0, this.elementData.length);
			this.elementData = newArray;
		}
		elementData[size++] = e;
	}
	
	public E get(int index) {
		checkRange(index);
		return (E)this.elementData[index];
	}
	
	public void set(E e,int index) {
		checkRange(index);
		elementData[index] = e;
	}
	
	//检查索引的合法性
	public void checkRange(int index) {
		if(index < 0 || index > size-1) {
			throw new RuntimeException("索引不和法："+index);
		}
	}
	
	public boolean isEmpty() {
		return size == 0 ?true:false;
	}
	
	public int length() {
		return this.size;
	}
	
	public void remove(E e) {
		//e，将它和所有元素挨个比较，获得第一个比较为true，返回
		for (int i = 0;i<size;i++) {
			if(e.equals(get(i))) { //容器中所有的比较操作都是使用equals而不是使用==
				//将元素从此处移除
				remove(i);
			}
		}
	}
	
	public void remove(int index) {
		//
		checkRange(index);
		if(this.elementData.length-index-1 >0)
			System.arraycopy(this.elementData,index+1,this.elementData, index,this.elementData.length-index-1);
		this.elementData[--size] = null;
	}
	 
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0;i <size;i++) {
			if(i != 0)
				sb.append(",");
			sb.append(elementData[i]);
			
		}
		sb.append("]");
		return sb.toString();
	}
	
}
