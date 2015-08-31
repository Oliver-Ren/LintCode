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

/** The iterative solution using binary tree level order traversal.
 * time complexity: O(n)
 * space complexity: O(sqrt(n))
 * status: accepted, 639msms.
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		
		if (root == null) {
			return;
		}

		nodeQueue.offer(root);

		while (!nodeQueue.isEmpty()) {
			int size = nodeQueue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = nodeQueue.poll();
				TreeNode temp = curr.left;
				curr.left = curr.right;
				curr.right = temp;

				if (curr.left != null) {
					nodeQueue.offer(curr.left);
				}

				if (curr.right != null) {
					nodeQueue.offer(curr.right);
				}

			}
		}

	}
}
