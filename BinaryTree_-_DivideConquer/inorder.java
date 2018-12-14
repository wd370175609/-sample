public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){           //be careful of the cur!=null here
            while(cur!=null){                   //make sure the most left will be pop first
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
