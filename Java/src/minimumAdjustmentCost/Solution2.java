public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        // precondition: A is not null and target is no less than 0.
        if (A == null || target < 0) throw new IllegalArgumentException();
        
        int n = A.size();
        int m = 100;
        int[][] f = new int[n + 1][m + 1];
        
        // init
        
        // recurrence
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
                //if (Math.abs(A.get(i - 1) - j) > target) continue;
                int lo = Math.max(1, j - target);
                int hi = Math.min(j + target, m - 1);
                for (int k = lo; k <= hi; k++) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(A.get(i - 1) - j));
                }
            }
        }
        
        // answer
        int minCost = Integer.MAX_VALUE;
        for (int j = 1; j <= m; j++) {
            minCost = Math.min(f[n][j], minCost);
        }
        
       // return minCost;
       return minCost;
    }
}
