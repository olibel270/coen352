public class ISort {
	public static void main(String[] args){
		//Int cast
		int to_sort[] = new int[args.length];
		for(int i=0;i<args.length;i++)
			to_sort[i] = Integer.parseInt(args[i]);
		
		// =================== Show array to be sorted ==================
		System.out.print("Sorting: ");
		for(int i=0;i<to_sort.length;i++) {
	        System.out.print(to_sort[i]);
	        System.out.print(" ");
		}
		System.out.print("\n");
		
		// =================== Sort Array =====================
		int	swap_counter = 0;
		long nano_start_time = System.nanoTime();
		for(int i=0;i<to_sort.length;i++) {
			for(int j=i; (j>0) && ((int)to_sort[j]<(int)to_sort[j-1]); j--) {
				swap(to_sort, j, j-1);
				swap_counter++;
			}
		}
		long nano_end_time = System.nanoTime();
		long nano_execution_time = nano_end_time - nano_start_time;
		
		//======Show completion time=============
		System.out.print("Completed in ");
		System.out.print(nano_execution_time);
		System.out.println("ns.");

		//======Show # of Comparisons=============
		System.out.print("Comparisons: ");
		System.out.println(swap_counter);
		
		//========show Sorted array ============
		System.out.print("Sorted: ");
		for(int i=0;i<to_sort.length;i++) {
	        System.out.print(to_sort[i]);
	        System.out.print(" ");
		}
		System.out.print("\n");
	}
	
	  public static void swap(int[] A, int p1, int p2) {
		    int temp = A[p1];
			A[p1] = A[p2];
			A[p2] = temp;
		  }
}
