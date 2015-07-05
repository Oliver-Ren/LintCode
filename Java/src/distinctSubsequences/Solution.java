public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
		int lenS = S.length();
		int lenT = T.length();
		int[][] dp = new int[lenS + 1][lenT + 1];

		/* T is empty string, and is subsequences of every
		 * substring  of S. */
		for (int i = 0; i <= lenS; i++) {
			dp[i][0] = 1;
		}
		
		/* S is empty string, and every non-empty string 
		 * is not substring of S. */
		for (int j = 1; j <= lenT; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= lenS; i++) {
			for (int j = 1; j <= lenT; j++) {
				
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[lenS][lenT];
	

			

    }
}
