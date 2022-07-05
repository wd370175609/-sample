public class Solution {
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums==null || nums.length==0){
            return -1;
        }
        
        int start=0, end = nums.length-1;
        while(start+1<end){
            int mid = start + (end - start)/2;
            if(nums[mid]==target){
                return mid;     //first position:end=mid; last position:start=mid;
            }
            else if(nums[mid]<target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if(nums[start]==target){//first position:check start first. last position:check end first, use example to verify!! check lc302
            return start;
        }
        else if(nums[end]==target){
            return end;
        }
        return -1;
    }
}
