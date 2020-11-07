public class queue{
	int max=10;
	int front=-1;
	int rear=0;
	int len=0;
	int first=-1;
	int[] temp=new int[max];//declearing 

	public void enqueue(int e){
		if(len==0){
			temp[0]=e;
			front=0;
		}
		else{
			temp[rear+1]=e;
			rear=rear+1;
			rear++;
		}
		len=len+1;
		System.out.println(e);

	}
	public int dequeue(){
		if(len==0){
			System.out.println("empty");
		}
		else{
			front=front-1;
			len=len-1;

		}
		return temp[front+1];
	}
	public int len(){
		return len;
	}
	public int first(){
		if(isEmpty()){
			return 0;
		}
		else{
			return temp[front];
		}
	}
	public boolean isEmpty(){
		if(len==0){
			return true;
		}
		else{
			return false;
		}

	}
	public int front(){
		return temp[front];
	}
	public static void main(String[] args){
		queue som=new queue();

		som.enqueue(2);
		som.enqueue(7);
		som.enqueue(4);


		System.out.println(som.first());
		System.out.println(som.isEmpty());
		System.out.println(som.dequeue());
	}
}