
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

/** The recursive solution.
 * time complexity: O(n)
 * space complexity: O(logn)
 * status: accepted, 775ms.
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
		if (root == null) {
			return;
		}


		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertBinaryTree(root.left);
		invertBinaryTree(root.right);

    }
}

