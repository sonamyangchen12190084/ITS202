class queuelinkedlist {
	Node front;
	Node tail;
	int size;
	public queuelinkedlist() {
		front = null;
		tail = null;
		size = 0;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	//adding the element
	public void enqueue(int data) {
		Node newNode = new Node(data, null);
		if(size == 0) {
			front = newNode;
			tail = newNode;
			System.out.println("The enqueue data is = " +data);
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
			System.out.println("The enqueue data is= " +data);
		}
		size = size + 1;
	}
	// removing the elememt 
	public int dequeue() {
		int removeddata = front.getElement();
		if(isEmpty()) {
			return 1;
		}
		else {
			front = front.getNext();
			size -= 1;
			System.out.println("The dequeued data is = " +removeddata);
		}
		return removeddata;
	}
	
	public int first() {
		int firstdata = front.getElement();
		if(size == 0) {
			System.out.println("StackUnderFlowError");
		}
		else {
			return firstdata;
		}
		return first();
	}
	public int len() {
		if(isEmpty()) {
			return 1;
		}
		return size;
	}
	//test
	public static void main(String[] args) {
		queuelinkedlist obj = new queuelinkedlist();
		obj.enqueue(3);
		obj.enqueue(7);
		obj.enqueue(3);

		System.out.println("The deleted data is = "+obj.dequeue());
		System.out.println("The first data is = " +obj.first());
		System.out.println("" +obj.isEmpty());
		System.out.println("The length of a queue elements is : " + obj.len());

		
		assert(obj.isEmpty() == false);
		assert(obj.first() == 7);
		assert(obj.len() == 2);
		System.out.println("All the test are passed");
		
	}
}
class Node{
	//Variable declaration
	private int element;
	private Node next;
	public Node(int element, Node next) {
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement() {
		return element;
	}
	//getNext
	public Node getNext() {
		return next;
	}
	//setElement
	public void setElement(int e) {
		element = e;
	}
	//setNext
	public void setNext(Node e) {
		next = e;
	}
}
