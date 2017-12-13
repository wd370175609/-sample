/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if(graph==null)
            return null;
        Map<DirectedGraphNode, Integer> map=new HashMap<>();  //use for store node and indegree
        
        //compute the indegree
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode neighbor: node.neighbors){
                if(map.containsKey(neighbor))
                    map.put(neighbor,map.get(neighbor)+1);
                else
                    map.put(neighbor,1);
            }
        }
        
        Queue<DirectedGraphNode> que=new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        //add the node where indegree is 0 to queue. Everytime when node was added to queue, that means the node has been removed from graph, so its neighbors should minus 1 for indegree.
        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                que.offer(node);
                res.add(node);
            }
        }
        
        //BFS to finish topological sort
        while(!que.isEmpty()){
            DirectedGraphNode node=que.poll();
            for(DirectedGraphNode neighbor: node.neighbors){
                map.put(neighbor, map.get(neighbor)-1);
                if(map.get(neighbor)==0){
                    que.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        return res;
    }
}
