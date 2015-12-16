import java.util.Arrays;
/**
 * Dynamic Programming solution.
 * State: f(i, j) is the maximum value of the first i items with the total
 * weight of exactly j.
 * Function: f(i, j) = max(f(i - 1, j), f(i - 1, j - A(i)) + V(i)).
 * Init: f(i, 0) = 0, f(0, j) = -inf. f(0,0) = 0;
 * Answer: f(n, m);
 * 
 * Time Complexity: O(n^2).
 * Space Complexity: O(n^2).
 * Status: Accepted.
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        // precondition: m >= 0, A and V are not null.
        if (m < 0 || A == null || V == null) {
            throw new NullPointerException();
        }

        int n = A.length;
        int[][] f = new int[n + 1][m + 1];

        // init
        Arrays.fill(f[0], Integer.MIN_VALUE);
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int temp = Integer.MIN_VALUE;
                if (j >= A[i - 1]) {
                    temp = f[i - 1][j - A[i - 1]] + V[i - 1];
                }

                f[i][j] = Math.max(f[i - 1][j], temp);
            }
        }

        // find the maximum value.
        int maxValue = Integer.MIN_VALUE;
        for (int j = 0; j <= m; j++) {
            maxValue = Math.max(maxValue, f[n][j]);
        }


        return maxValue;
    }
}
