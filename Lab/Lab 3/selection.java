import java.util.Scanner;
class selection{

	public static void main(String[] args){
		Scanner n = new Scanner(System.in);
		System.out.println("enter the size of the array");
		int size = n.nextInt();
		
		int arr[]=new int[size];
		System.out.println("enter the value in the array:");
		
		for(int i=0;i<size;i++){
		
			int x = n.nextInt();
			arr[i]=x;
		}
		System.out.print("Array after selection sorting: ");
		selection(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		

		}
		public static void selection(int temp[]){
			
			int n = temp.length;
			for(int i=0;i<n-1;i++){
				int s=i;
			for(int k=i+1;k<n;k++)
				if(temp[s]>temp[k])
					s=k;
				{
					int x =temp[s];
					temp[s]=temp[i];
					
					temp[i]=x;
				}
			}
			

		}
		
		
	}
	
