/*Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.*/

 public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums==null || nums.length==0)
            return 0;
    
        int left=0, right=nums.length-1;
        
        while(left<right){
            while(left<right && nums[left]<k){
                left++;
            }
            while(left<right && nums[right]>=k){
                right--;
            }
            
            if(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
        }
        //if all element is less than k;
        if(nums[left]<k)
            return left+1;
            
        return left;
        
    }
