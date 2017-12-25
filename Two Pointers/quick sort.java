import java.util.Random;

public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    public Random rand;
    public void sortIntegers2(int[] A) {
        rand = new Random();
        // write your code here
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = rand.nextInt(end - start + 1)  + start;  //remember
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
}
