BFS in Binary Tree:
classical example (level order):

 public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> level=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode head=que.poll();
                level.add(head.val);
                if(head.left!=null)
                    que.offer(head.left);
                if(head.right!=null)
                    que.offer(head.right);
            }
            res.add(level);   
        }
        return res;
    }

the time and space complexity are both O(n)

BFS 序列化的问题：
ex:
Binary Tree Level Order Traversal II: leetcode 107
Binary Tree Zigzag Order Traversal: leetcode 103

BFS in graph:
construct the graph, 邻接表
ex: Graph Valid Tree: this



