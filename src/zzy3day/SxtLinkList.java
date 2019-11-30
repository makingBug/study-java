package zzy3day;


public class SxtLinkList<E> {
	public static void main(String[] args) {
		
		/*
		 * 测试get方法
		 */
		System.out.println("***************get方法测试*********************");
		SxtLinkList<Integer> get = new SxtLinkList<Integer>();
		for (int i =0;i <20;i++) {
			get.add(i);
		}
		System.out.println(get);
		System.out.println(get.get(18));
		System.out.println(get.get(1));
		
		/*
		 * 测试remove方法
		 */
		System.out.println("***************remove方法测试*********************");
		SxtLinkList<Integer> remove = new SxtLinkList<Integer>();
		for (int i =0;i <10;i++) {
			remove.add(i);
		}
		System.out.println(remove);
		for (int i =0;i<10;i++) {
			remove.remove(0);
			System.out.println(remove);
		}
		
		/*
		 * 测试中间插入
		 */
		System.out.println("***************add(index,e)方法测试*********************");
		SxtLinkList<Integer> add = new SxtLinkList<Integer>();
		System.out.println(add.isEmpty());
		for (int i =0;i <5;i++) {
			add.add(i);
		}
		System.out.println(add);
		add.add(4,100);
		System.out.println(add);
		
		System.out.println(add.isEmpty());
		
	}
	
	private class Node<E>{
		Node<E> previous;
		Node<E> next;
		E element;

		
		public Node(E e) {
			super();
			this.element = e;
		}
		
		
	}
	
	
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public SxtLinkList() {
		first = new Node<E>(null);
		last = new Node<E>(null);
		first.next = last;
		last.previous = first;
	}
	
	//尾插
	public void add(E e) {
		Node<E> node = new Node<E>(e);
		size += 1;
		
		Node<E> pre = last.previous;
		pre.next = node;
		node.next = last;
		
		last.previous = node;
		node.previous = pre;
	}
	
	public void add(int index,E e) {
		checkRange(index);
		Node<E> curNode = getNode(index);
		Node<E> node = new Node<E>(e);
		Node<E> pre = curNode.previous;
		
		node.next = curNode;
		pre.next = node;
		node.previous = pre;
		curNode.previous = node;
		this.size += 1;
		
		
		
	}
	
	private void checkRange(int index) {
		if(index < 0 || index > size-1) {
			throw new RuntimeException("索引越界："+index+";数组范围："+this.size);
		}
	}
	
	//双链表，查找分情况，从头开始还是从尾开始
	public E get(int index) {
		Node<E> node = getNode(index);
		return node == null?null:(E)node.element;
		
	}
	
	private Node<E> getNode(int index) {
		checkRange(index);
		Node<E> node;
		if(index< (size >>1)) {
			node = first;
			for (int i = 0;i <= index;i++) {
				node = node.next;
			}
		}else {
			node = last;
			for (int i =0;i<=size-1-index;i++) {
				node = node.previous;
			}
		}
		return node;
	}
	
	public E remove(int index) {
		checkRange(index);
		Node<E> node = getNode(index);
		Node<E> pre = node.previous;
		Node<E> next = node.next;
		pre.next = next;
		next.previous = pre;
		size -= 1;
		return (E)node.element;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> temp = this.first;
		for (int i = 0;i<this.size;i++) {
			temp = temp.next;
			if(i != 0)
				sb.append(",");
			sb.append(temp.element);
		}
		sb.append("]");
		return sb.toString();
		
		//调试使用
//		StringBuilder sb = new StringBuilder();
//		sb.append("[");
//		Node<E> node = first;
//		while(node != null) {
//			sb.append(node.element);
//			sb.append(" ");
//			node = node.next;
//		}
//		sb.append("]");
//		return sb.toString();
	}
	
	public boolean isEmpty() {
		return this.size == 0?true:false;
	}
}

