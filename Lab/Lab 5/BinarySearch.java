public class BinarySearch{
	public static int Binary(int []arr,int l,int h,int y) {
		if(h>=l){
			int middle=l+(h-l)/2;

			if(arr[middle]==y){
				return middle;
			}
			else if(arr[middle]>y){
				return Binary(arr,l,h-1,y);
			}
			else{
				return Binary(arr,l,h+1,y);
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		BinarySearch obj=new BinarySearch();
		int arr[]={1,2,3,4,5,6,7,8,9};
		int y=8;
		int n=arr.length;
		int display=obj.Binary(arr,0,n-1,y);
		if(display==-1){
			System.out.println("target element not found!!");
		}
		else{
			System.out.println("target element found!");
		}
	}
}