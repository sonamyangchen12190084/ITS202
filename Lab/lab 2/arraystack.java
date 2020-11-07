public class arraystack{
	//ddeclearing an variable: where max is the size of an array
	int max= 10;
	//initial size and top will be zero
	int top= -1;
	int size=0;
	//creating array of size 10 i.e max
	int[] array= new int[max];

	public void push(int e){
		if(size==0){
			array[0]= e;
			top=0;
		}
		else{
			array[top + 1]= e;
			top= top + 1;
		}
		size= size + 1;
		System.out.println(e);
	}
	public int pop(){
		if(size==0){
			System.out.println("arraystack is empty:");
		}
		else{
			top=top -1;
			size=size -1;
		}
		return array[top+1];
	}
	//returning top of element in stack
	public int top(){
		return array[top];
	}
	//returning the size of array 
	public int size(){
		return size;
	}
	//checking the stack whethere it is empty or not
	public boolean isEmpty(){
		if(size()==0){
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		arraystack obj = new arraystack();
		obj.push(50);
		obj.push(20);
		obj.push(70);

		System.out.println("removed array is: "+obj.pop());
		System.out.println("array top is:"+obj.top());
		System.out.println("size of the array:"+obj.size());
		System.out.println(obj.isEmpty());
	}
}