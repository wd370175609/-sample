import java.util.Random;

public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    
    
    static Random rand = new Random();
	public static int partition(int left, int right, int[] arr){
		int pivot = arr[right];
		int index = left;   
		for(int i = left; i < right; i++){
			if(arr[i] < pivot){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;    //index will point to the element which is larger and equal to pivot.
			}
		}
        int temp = arr[index]; 
        arr[index] = arr[right]; 
        arr[right] = temp; 
        return index;
	}
	public static void sort(int left, int right, int[] arr){
		printArray(arr);
		if(left >= right)
			return;
        // Recursively sort elements before 
        // partition and after partition 
		int pivot = partition(left, right, arr);
		sort(left, pivot - 1, arr);
		sort(pivot + 1, right, arr);
	}
    
    /*public Random rand;
    public void sortIntegers2(int[] A) {
        rand = new Random();
        // write your code here
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = rand.nextInt(end - start + 1)  + start;  //remember  Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)
        int pivot = A[index];
        int left = start;
        int right = end;
        
        while (left <= right) {            //remember <=, so that 'left' will be on the right side of 'right'
            while (left <= right && A[left] < pivot) {
                left ++;
            }
            while (left <= right && A[right] > pivot) {
                right --;
            }
            //if '==', also switch the position.
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left ++;
                right --;
            }
        }
        // A[start... right] 
        quickSort(A, start, right);
        // A[left ... end]
        quickSort(A, left, end);
    }
    */
}
