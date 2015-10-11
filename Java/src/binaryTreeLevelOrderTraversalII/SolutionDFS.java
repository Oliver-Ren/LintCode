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
 * status: not finished.
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		dfs();
		return result;
	}

	private void dfs(TreeNode root, int level, List<List<Integer>> result) {
		if (root == null) {
			return;
		}

		if (level > result.size()) {
			result.add(0, new ArrayList<Integer>());
		}

		result.get(level).add

		


