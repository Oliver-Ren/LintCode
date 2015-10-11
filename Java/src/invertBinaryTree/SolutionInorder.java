
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

/** The iterative solution using binary tree in-order traversal.
 * time complexity: O(n)
 * space complexity: O(logn)
 * status: accepted, 655ms. 
 */

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		
		if (root == null) {
			return;
		}

		nodeStack.push(root);

		while (!nodeStack.empty()) {
			TreeNode curr = nodeStack.pop();
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;

			if (curr.right != null) {
				nodeStack.push(curr.right);
			}

			if (curr.left != null) {
				nodeStack.push(curr.left);
			}
		}

	}

}
