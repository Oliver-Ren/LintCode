/**
 * Dynamic programming Soluiton.
 * State: f(i, j) represents the existance of the sum of first i numbers
 * equal to j.
 * Function: f(i, j) = f(i - 1, j) or f(i - 1, j - A[i]).
 * Initialization: f(i, 0) = true, f(0, j) = false; f(0,0) = true;
 * Answer: max j such that f(n, j) == true;
 *
 * Time complexity: O(n ^ 2);
 * Space complexity: O(n ^ 2);
 * Status: Accepted.
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        // precondition: m >= 0 and A is not null;
        if (m < 0 || A == null) throw new IllegalArgumentException();

        int n = A.length;
        boolean[][] f = new boolean[n + 1][m + 1];
        
        // initialize
        for (int i = 0; i <= n; i++) {
            f[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i - 1] && f[i - 1][j - A[i - 1]]) f[i][j] = true;
            }
        }

        for (int j = m; j >= 0; j--) {
            if (f[n][j]) {
                return j;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {3,4,8,5};
        s.backPack(10, a);
    }

}
