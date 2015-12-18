import java.util.ArrayList;
import java.util.Arrays;
/**
 * Dynamic Programming Solution.
 * State: f(i,j) represents minimum adjustment cost of the first i items
 * in A with the ith item being adjusted to j.
 * recurrence: f(i, j) = min{f(i - 1, j') + |A[i] - j|} 
 * where |j - j'| leq target. 
 * Initialize: f(0, 0) = 0, f(0, A[0]) = 0, f(0, A[0] +- X) = X where X is pos.
 * Answer: Min{f(n, j)} where j 
 */
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        // precondition: A is not null, target is no less than 0
        if (A == null || target < 0) throw new IllegalArgumentException();
        if (A.size() == 0) return 0;

        int[][] f = new int[A.size()][101];
        // init
        for (int i = 0; i <= 100; i++) {
            f[0][i] = Math.abs(A.get(0) - i);
        }

        for (int i = 1; i < A.size(); i++) {
            for (int j = 1; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
                int minVal = Integer.MAX_VALUE;
                for (int k = 1; k <= 100; k++) {
                   if (Math.abs(j - k) > target) {
                       continue;
                    }
                   minVal = Math.min(minVal, f[i - 1][k] + Math.abs(A.get(i) - j));
                }
                f[i][j] = minVal;
            }
        }
        


        int globalMin = Integer.MAX_VALUE;
        for (int j = 1; j <= 100; j++) {
            globalMin = Math.min(globalMin, f[A.size() - 1][j]);
        }
        

        return globalMin;

         
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(1,4,2,3));   
        System.out.println(s.MinAdjustmentCost(l, 1));
    }
        
}
