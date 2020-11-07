public class activity1
{
	static int[] array;
	public static void main(String args[]){
		array=new int[3];
		array[0]=2;
		array[1]=4;
		array[2]=6;
		int[] size = resize(4);
		for (int x=0;x< size.length;x++){
			System.out.println(size[x]);
		}

	}

	public static int [] resize(int length ){
		int[] size =new int[length];
		for(int x=0;x<array.length;x++){
			size[x]=array[x];
		}
		size[length-1]=4;
		array=size;
		return array;
	}
}
