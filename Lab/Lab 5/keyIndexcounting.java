public class keyIndexcounting{

	public static void main(String[] args){
		int a[] ={1,2,3,4,8,9,5,0,5};
		int N = a.length;
		int R = 256;

		int[] aux = new int[N];
		int[] count = new int[R+1];

		//compute frequency counts
		for(int i = 0; i<N; i++)
			count[a[i]+1]++;
		//transform count to indices
		for(int r = 0;r < R; r++)
			count[r+1]+= count[r];
		//distribute the records
		for(int i = 0;i<N;i++)
			aux[count[a[i]]++] = a[i];
		//copy back
		for(int i=0; i<N;i++)
			a[i] = aux[i];

		for(int i=0;i<N;i++){
			System.out.print(" " +a[i]);
		}


	}


}