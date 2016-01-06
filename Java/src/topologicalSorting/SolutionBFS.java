import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

/*
 * The BFS solution.
 * Time complexity: O(E+V)
 * Space Complexity: O(E+V)
 * Status: Accepted, 2468ms.
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        
        if (graph == null) return result;

        Map<DirectedGraphNode, Integer> indegree = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        // first round: calculate the indegree.
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, 0);
                }
                
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        // second round: sort by topological order.
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) queue.offer(node);
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode curr = queue.poll();
            result.add(curr);
            for (DirectedGraphNode neighbor : curr.neighbors) {
                int currIndegree = indegree.get(neighbor);
                if (currIndegree == 1) {
                    indegree.remove(neighbor);
                    queue.offer(neighbor);
                } else {
                    indegree.put(neighbor, currIndegree - 1);
                }
            }
        }

        return result; 
    }
}
