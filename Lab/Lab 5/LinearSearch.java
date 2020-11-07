public class LinearSearch{
	public static int Linearsearch(int[]array,int k){
		int n = array.length;
		for(int i=0;i<n;i++){
			if(array[i]==k){
				return i;
			}
		}
		
		return -1;
}

	public static void main(String[] args){
		int []array={3,6,7,1,2,0};
		int l=array.length;
		int k=7;

		int show = Linearsearch(array, k);
		if(show==-1){
			System.out.println("not found");
		}
		else{
			System.out.println("found");
		}

	}

}