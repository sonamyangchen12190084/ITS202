import java.util.Scanner;
class array{

	public static void main(String[] args){
		Scanner n = new Scanner(System.in);
		System.out.println("enter the size of the array");

		int size = n.nextInt();
		int arr[]=new int[size];
		System.out.println("enter the value in the array:");
		for(int i=0;i<size;i++){
			//System.out.println("Enter the value in the array:");
			arr[i]=n.nextInt();
		}
		//calling method insertion
		System.out.print("Array after insertion sorting: ");
		insertion(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		

	}

	public static void insertion(int temp[]){
		int i,j,k;//initialize 
			for(i=1;i<temp.length;i++){
			k=temp[i];
			j=i -1;
			while(j>=0 && temp[j]>k)
			{
				temp[j+1]=temp[j];
				j=j-1;
			}
			temp[j+1]=k;
	}
}

		
		
}
