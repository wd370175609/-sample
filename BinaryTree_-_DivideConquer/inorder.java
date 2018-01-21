public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
