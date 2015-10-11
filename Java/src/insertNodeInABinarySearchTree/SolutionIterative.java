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


/* The iterative solution.
 * time complexity: O(logn)
 * space complexity: O(1)
 * status: accepted, 1629ms.
 */

public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
		if (root == null) {
			return node;
		}

		TreeNode prev = root;
		TreeNode curr = root;

		while (curr != null) {
			prev = curr;
			if (node.val > curr.val) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}

		if (prev.val < node.val) {
			prev.right = node;
		} else {
			prev.left = node;
		}

		return root;
	}
}

