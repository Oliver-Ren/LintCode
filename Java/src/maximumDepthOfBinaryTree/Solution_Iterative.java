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

/* The iterative solution based on level order traversal.
 * time complexity: O(n), where n is the number of nodes.
 * space complexity: O(sqrt(n)) in the worst case.
 * status: accepted, 2697ms. 
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		if (root == null) {
			return 0;
		}

		nodeQueue.offer(root);
		int depth = 0;

		while (!nodeQueue.isEmpty()) {
			depth++;
			int size = nodeQueue.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = nodeQueue.poll();
				
				if (curr.left != null) {
					nodeQueue.offer(curr.left);
				}

				if (curr.right != null) {
					nodeQueue.offer(curr.right);
				}

			}
		}

		return depth;
	}
}
				

