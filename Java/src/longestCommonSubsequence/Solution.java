/**
 * Dynamic Programming solution.
 * State: f[i][j] represents the length of LCS of 
 * first i characters in sequence 1 matches the 
 * first j characters in sequence 2.
 * Function: f[i][j] = f[i - 1][j - 1] + 1, if A[i] == B[j]
 *                     max(f[i - 1][j], f[i][j - 1], if A[i] != B[j].
 * Initialize: f[i][0] = 0, f[0][j] = 0;
 * Answer: f[A.length()][B.length()];
 * 
 * Time complexity: O(n^2).
 * Space complexity: O(n).
 * Status: 
 */ 
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // precondition: A and B are not null
        if (A == null || B == null) throw new NullPointerException();
        char[] strA = A.toCharArray();
        char[] strB = B.toCharArray();

        int[][] f = new int[A.length() + 1][B.length() + 1];
        
        // init
        for (int i = 0; i < A.length(); i++) {
            f[i][0] = 0;
        }

        for (int j = 0; j < B.length(); j++) {
            f[0][j] = 0;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (strA[i - 1] == strB[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[A.length()][B.length()];
    }
}

