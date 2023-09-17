import java.util.Random;

public class QuickerThanQuicksort {
	
	private Random random;

	public QuickerThanQuicksort() {
		random = new Random();
	}
	

	
	public void insertionSort(float [] arr, int bot, int top)
	{
		for (int i = bot + 1; i <= top; i++) { // "i" is 1st unsorted item
			float temp = arr[i]; // Copy
			int j = i - 1;
			while (j >= bot && arr[j] > temp) { // Move (loop)
				arr[j+ 1] = arr[j];
				--j;
			}
			arr[j+ 1] = temp; // Copy back
		}
	}
	
	public void hybridSort (float [] arr) {
		hybridSort(arr, 0, arr.length - 1);
	}
	
	public void hybridSort (float [] arr, int bot, int top) {
		if (bot < top) { // Base case (top < bot) is NOP
			
			if (top + 1 - bot <= 20) {
				insertionSort(arr, bot, top);
			}
			else {			
				int p = quickSort(arr, bot, top);
				hybridSort(arr, bot, p-1); // All values in left are <= arr[p]
				hybridSort(arr, p+1, top);
			}
		}
	}
	
	public int quickSort(float [] arr, int left, int right) {
		// Base case -- or reverse of the base case
		int bot = left;

		if (left < right) {
			// Setup: pivot is last item
			int pivot = right;
			int top = right-1; // Avoids re-sorting the pivot
			int random_pivot = get_random_pivot(left, right);

			swap(arr, pivot, random_pivot);
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
	
	public int get_random_pivot(int left, int right)
	{
		int length = right + 1 - left;
		int nextRandom = random.nextInt();
		if (nextRandom < 0) {
			nextRandom = -nextRandom;
		}
		int random_pivot = left + nextRandom % length;
		
		return random_pivot;
	}
	
	public void swap (float [] arr, int i, int j) {
		float temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
