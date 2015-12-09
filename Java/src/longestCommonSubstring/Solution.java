/** 
 * Dynamic programming solution.
 * State: f[i][j] represents the longest common substring which
 * ends with i for string 1, and j for string 2.
 * Function: f[i][j] = f[i - 1][j - 1] + 1 if A[i] == B[j];
 *                     0, otherwise.
 * Initiallize: f[i][0] = 0; f[0][j] = 0;
 * Answer: Max(f[i][j])
 *
 *
 * Time complexity: O(n*m);
 * Space Complexity: O(n * m);
 * Status: Accepted, 2050ms.
 */
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        // preconditioN: A and B are not null
        if (A == null || B == null) throw new NullPointerException();

        int m = A.length();
        int n = B.length();

        int[][] f = new int[m + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = A.charAt(i - 1) == B.charAt(j - 1)
                    ? f[i - 1][j - 1] + 1 : 0;
                maxLen = Math.max(maxLen, f[i][j]);
            }
        }

        return maxLen;
    }
}

