public int twoSumCloset(int[] nums, target){
  if(nums == null)}
    return -1;
  }
  
  Arrays.sort(nums);
  int i=0, j=nums.length-1;
  int best = Integer.MAX_VALUE;
  while(i<j){
    int differ = Math.abs(nums[i]+nums[j]-target);
    best = Math.min(best,diff);
    if(nums[i]+nums[j] < target){
      i++;
    }
    else 
      j--;
  }
  
  return best;
 }
    
