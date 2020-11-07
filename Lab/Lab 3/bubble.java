import java.util.Scanner;
public class bubble{
	public static void bubblesort(int arr[]){
	int n = arr.length;  
    int temp = 0;  
    for(int i=0; i < n; i++){  
        for(int j=1; j < (n-i); j++){  
            if(arr[j-1] > arr[j]){  
                 //swap elements  
                temp = arr[j-1];  
                arr[j-1] = arr[j];  
                arr[j] = temp;  
                 }  
             }  
        }  
	}
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
		//calling method bubblesort
		System.out.print("Array after bubblesort: ");
		bubblesort(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		

	}

}