/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
     
    public void flatten(TreeNode root) {
        // write your code here
        helper(root);
    }
    //use divide conquer to solve the problem
    TreeNode helper(TreeNode root){
        if(root==null)
            return null;
        
        TreeNode left=helper(root.left);
        TreeNode right=helper(root.right);

        root.left=null;
        root.right=left;
        
        TreeNode cur=root;
        while(cur!=null){
            if(cur.right==null){
                cur.right=right;
                break;
            }
            cur=cur.right;
        }
        return root;
    }
}
