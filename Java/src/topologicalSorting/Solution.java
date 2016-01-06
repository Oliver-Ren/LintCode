/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

/**
 * The reverse DFS postorder.
 * Time complexity: O(E+V) where E is the number of edges
 * and V is the number of vertices.
 * Space complexity: O(E+V).
 * Status:
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        Stack<DirectedGraphNode> nodeStack = new Stack<DirectedGraphNode>();
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();

        if (graph == null) return result;

        for (DirectedGraphNode node : graph) {
            if (!visited.contains(node)) {
                dfs(node, nodeStack, visited);
            }
        }


        // reverse the stack order
        while (!nodeStack.isEmpty()) {
            result.add(nodeStack.pop());
        }
    
        return result;
    }

    // helper method for dfs
    private void dfs(DirectedGraphNode graph, Stack<DirectedGraphNode> nodeStack,
            Set<DirectedGraphNode> visited) {
        // preconditon graph is not null
        visited.add(graph);
        for (DirectedGraphNode neighbor : graph.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, nodeStack, visited);
            }
        }

        nodeStack.push(graph);
    }
}
