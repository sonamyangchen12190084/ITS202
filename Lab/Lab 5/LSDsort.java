public class LSDsort{
	public static void main(String[] args){

		int w=6;
		String []a={"wangmo","tobgay","sonamo","tenzin"};
		int N =a.length;
		int R =256;
		String[] aux = new String[N];

		for(int d=w-1; d>=0; d--){
			//sort by key indexed counting on dth char
			int[] count= new int[R+1];
			//compute frequency count
			for(int i =0;i<N;i++)
				count[a[i].charAt(d) + 1]++;

			for(int r=0;r<R;r++)
				//transform count to indices
				count[r+1] += count[r];
			for(int i =0;i<N;i++)
				//distribute
				aux[count[a[i].charAt(d)]++] = a[i];
			for(int i =0; i<N; i++)
				//copy back
				a[i] =aux[i];
		}
		for(int i=0;i<N;i++)
			System.out.println(" " +a[i]);

	}
}