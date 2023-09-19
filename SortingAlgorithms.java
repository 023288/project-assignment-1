



public class SortingAlgorithms {
	
	public SortingAlgorithms()
	{
		
	}
	
	public long sort(String algorithm, float [] arr)
	{
		long beginTimeMillis = System.currentTimeMillis();
		
		if (algorithm.equals("insertion")) {
			insertionSort(arr);
		}
		else if (algorithm.equals("bubble")) {
			bubbleSort(arr);
		}
		else if (algorithm.equals("selection")) {
			selectionSort(arr);
		}
		else if (algorithm.equals("quick")) {
			quickSort(arr);
		}
		else if (algorithm.equals("merge")) {
			mergeSort(arr);
		}

		long endTimeMillis = System.currentTimeMillis();

		return endTimeMillis - beginTimeMillis;
	}
	
	public void insertionSort(float [] arr)
	{
		for (int i = 1; i < arr.length; i++) { // "i" is 1st unsorted item
			float temp = arr[i]; // Copy
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) { // Move (loop)
				arr[j+ 1] = arr[j];
				--j;
			}
			arr[j+ 1] = temp; // Copy back
		}
	}
	
	public void bubbleSort (float [] arr) {
		boolean swapped = true; // Initial value ensures outer loop starts

		for (int i = 0; swapped && i < arr.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+ 1]) {
					swap(arr, j, j+ 1);
					swapped = true;
				}
			}
		}
	}
	
	public void selectionSort(float [] arr)
	{
		int smallest = 0;
		
		for (int i = 0; i < arr.length - 1; i++) // "i" is 1st unsorted item
		{
			smallest = findSmallest(arr, i);
			if (smallest != i) {
				swap(arr, i, smallest);
			}
		}
	}
	
	public int findSmallest ( float [] arr, int start) {
		int smallest = start; // Assume first item is smallest
		
		for (int i = start+ 1; i < arr.length; i++)
		{
			if (arr[i] < arr[smallest]) // Change smallest, as necessary
			{
				smallest = i;
			}
		}
		return smallest;
	}
	
	public void quickSort (float [] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public void quickSort (float [] arr, int bot, int top) {
		if (bot < top) { // Base case (top < bot) is NOP
			int p = partition(arr, bot, top);
			quickSort(arr, bot, p-1); // All values in left are <= arr[p]
			quickSort(arr, p+1, top);
		}
	}
	
	public int partition (float [] arr, int left, int right) {
		// Base case -- or reverse of the base case
		int bot = left;

		if (left < right) {
			// Setup: pivot is last item
			int pivot = right;
			int top = right-1; // Avoids re-sorting the pivot

			while (bot <= top) {
				// Count up from bot, down from top, swap ... on the next slide				
				while (bot < right && arr[bot] < arr[pivot])
				{
					++bot;
				}
				while (top >= bot && arr[top] >= arr[pivot])
				{	
					--top;
				}
				
				if (bot < top)
				{
					swap(arr, bot, top);
				}
				else
				{
					swap(arr, bot, pivot);
				}				
			}
		}
		return bot;
	}
	
	public void mergeSort(float [] arr) {
		if (arr.length > 1) {
			float [] left = get_left(arr);
			float [] right = get_right(arr);
			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		}
	}
	
	public void merge(float []arr, float []left, float []right)
	{
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex < left.length && rightIndex < right.length) {
			
			if (left[leftIndex] > right[rightIndex]) {
				arr[index++] = right[rightIndex++];				
			}
			else {
				arr[index++] = left[leftIndex++];
			}
		}

		while (leftIndex < left.length) {
			arr[index++] = left[leftIndex++];			
		}
		while (rightIndex < right.length) {
			arr[index++] = right[rightIndex++];			
		}

	
	}
	
	public float [] get_left( float [] arr) {
		int size = arr.length/ 2;
		float [] left = new float[size];
	
		for (int i = 0; i < size; i++) {
			left[i] = arr[i];
		}
		return left;
	}
	
	public float [] get_right( float [] arr) {
		int leftSize = arr.length/ 2;
		int size = arr.length - leftSize;
		float [] left = new float[size];
	
		for (int i = 0; i < size; i++) {
			left[i] = arr[i + leftSize];
		}
		return left;
	}
	
	public void swap (float [] arr, int i, int j) {
		float temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

}
