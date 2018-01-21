public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            res.add(temp.val);
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }
        return res;
    }
