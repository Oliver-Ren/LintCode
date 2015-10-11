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

/* using a stack.
 * time complexity: O(n)
 * space compelxity: O(sqrt(n))
 * status: accepted, 2150ms.
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
		Stack<ArrayList> levelStack = new Stack<ArrayList>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		if (root == null) {
			return result;
		}

		nodeQueue.offer(root);

		while (!nodeQueue.isEmpty()) {
			int size = nodeQueue.size();
			ArrayList<Integer> level = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {

				TreeNode curr = nodeQueue.poll();
				level.add(curr.val);

				if (curr.left != null) {
					nodeQueue.offer(curr.left);
				}

				if (curr.right != null) {
					nodeQueue.offer(curr.right);
				}
			}

			levelStack.push(level);
		}

		while (!levelStack.isEmpty()) {
			result.add(levelStack.pop());
		}

		return result;
    }
}

