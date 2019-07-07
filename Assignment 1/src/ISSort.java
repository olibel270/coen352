import java.util.ArrayList;

public class ISSort {
	static ArrayList<Integer> ascendingRunIndices = new ArrayList<Integer>();
	static ArrayList<Integer> descendingRunIndices = new ArrayList<Integer>();
	static int to_sort[];
	static int passIndex=0;
	
	public static void main(String[] args){
		//Int cast
		to_sort = new int[args.length];
		for(int i=0;i<args.length;i++)
			to_sort[i] = Integer.parseInt(args[i]);
		
		// =================== Show array to be sorted ==================
		System.out.print("Sorting: ");
		for(int i=0;i<to_sort.length;i++) {
	        System.out.print(to_sort[i]);
	        System.out.print(" ");
		}
		System.out.print("\n");
		
		
		//================== Start Timer ===================
		long nano_start_time = System.nanoTime();
		
		// =================== Perform Structuring Pass ==================
		for (;passIndex+1<to_sort.length;passIndex++) {
			if (to_sort[passIndex+1]>to_sort[passIndex]){
				ascendingRunIndices.add(passIndex);
				ascendingRun(passIndex);
			}
			else if (to_sort[passIndex+1]<to_sort[passIndex]){
				descendingRunIndices.add(passIndex);
				descendingRun(passIndex);
			}
		}
		
		// =================== Sort Array =====================
		int comp_counter=0;
		
		for(int i=0;i<to_sort.length;i++) {
			for(int j=i; (j>0) ;j--) {
				if((int)to_sort[j]<(int)to_sort[j-1]) {
					swap(to_sort, j, j-1);
					++comp_counter;
				}
				else {
					++comp_counter;
					break;
				}	
			}
		}
		// ================================================
		
		long nano_end_time = System.nanoTime();
		long nano_execution_time = nano_end_time - nano_start_time;
		
		//======Show completion time=============
		System.out.print("Completed in ");
		System.out.print(nano_execution_time);
		System.out.println("ns.");

		//======Show # of Comparisons=============
		System.out.print("Comparisons: ");
		System.out.println(comp_counter);
		
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
	
	public static void ascendingRun(int start_index) {
		if(start_index+1 < to_sort.length)
			if(to_sort[start_index+1]>to_sort[start_index])
				ascendingRun(start_index+1);
			else{
				ascendingRunIndices.add(start_index);
				passIndex = start_index;
				printAscendingRun();
			}
		else{
			ascendingRunIndices.add(start_index);
			passIndex = start_index;
			printAscendingRun();
		}
	}
	
	public static void descendingRun(int start_index) {
		if(start_index+1 < to_sort.length) {
			if(to_sort[start_index+1]<to_sort[start_index])
				descendingRun(start_index+1);
			else{
				descendingRunIndices.add(start_index);
				passIndex = start_index;
				printDescendingRun();
				revertDescendingRun();
			}
		}
		else {
			descendingRunIndices.add(start_index);
			passIndex = start_index;
			printDescendingRun();
			revertDescendingRun();
		}
	}
	
	public static void 	printAscendingRun(){
		int firstElementIndex = ascendingRunIndices.get(ascendingRunIndices.size()-2);
		int lastElementIndex = ascendingRunIndices.get(ascendingRunIndices.size()-1);
		for(int i=firstElementIndex;i<=lastElementIndex;i++) {
			System.out.print(to_sort[i]);
			System.out.print(" ");
		}
		System.out.println(">");
	}
	
	public static void 	printDescendingRun(){
		int firstElementIndex = descendingRunIndices.get(descendingRunIndices.size()-2);
		int lastElementIndex = descendingRunIndices.get(descendingRunIndices.size()-1);
		for(int i=firstElementIndex;i<=lastElementIndex;i++) {
			System.out.print(to_sort[i]);
			System.out.print(" ");
		}
		System.out.println("<");
	}
	
	public static void 	revertDescendingRun(){
		int firstElementIndex = descendingRunIndices.get(descendingRunIndices.size()-2);
		int lastElementIndex = descendingRunIndices.get(descendingRunIndices.size()-1);
		int midpoint = (firstElementIndex+lastElementIndex)/2;
		for(int i=firstElementIndex;i<=midpoint;i++) {
			swap(to_sort,firstElementIndex,lastElementIndex);
			firstElementIndex++;
			lastElementIndex--;
		}
	}
}
