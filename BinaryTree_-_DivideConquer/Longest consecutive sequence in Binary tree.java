
//use traverse to find max value, use divide conquer to store current value;
class GfG
{
    int maxlc=1;
	public int longestConsecutive(TreeNode root)
        {
         //add code here.
         
           helper(root);
           if(maxlc==1)
            return -1;
         
           return maxlc;
 
        }
    public int helper(TreeNode root){
         if(root==null){
                return 0;
            }
           
            int leftlc=helper(root.left);
            int rightlc=helper(root.right);
            int subtreelongest=1;
            if(root.left!=null && root.left.key==root.key+1){
                subtreelongest=Math.max(subtreelongest,leftlc+1);
            }
            if(root.right!=null && root.right.key==root.key+1)
                subtreelongest=Math.max(subtreelongest,rightlc+1);
                
            if(maxlc<subtreelongest)
                maxlc=subtreelongest;
            
            return subtreelongest;
    }
}
