public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

    public boolean validTree(int n, int[][] edges) {
        // write your code here
        
        //first judge case
        if(edges.length!=n-1)
            return false;
            
        Map<Integer, Set<Integer>> map=init(n, edges);
        Queue<Integer> que=new LinkedList<Integer>();
        Set<Integer> set=new HashSet<Integer>();   //to store the node
        que.offer(0);
        set.add(0);
        
        //traverse every node and check whether the size of set can be the same as node;
        while(!que.isEmpty()){
            int size=que.size();
            int currentnode=que.poll();
            for(Integer neighbor: map.get(currentnode)){
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                que.offer(neighbor);
            }
            
        }
        if(set.size()==n)
            return true;
        return false;
        
    }
    //construct graph
    private Map<Integer, Set<Integer>> init(int n, int[][] edges){
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,new HashSet());
        }
        for(int i=0;i<edges.length;i++){
            int key=edges[i][0];
            int value=edges[i][1];
            map.get(key).add(value);
            map.get(value).add(key);
        }
        return map;
    }
    
    
}
