/**
 * The Dynamic Programming Solution.
 * State: f(i,j,t) represents: i - the first i numbers in A
 *                             j - j numbers are chosen
 *                             t - those chosen numbers have sum of t
 *                             f(i,j,t) - total number of solutions.
 * Recurrence: f(i,j,t) = f(i - 1, j, t) // the ith number is not chosen
 *                        + f(i - 1, j - 1, t - A[i]) // the ith number chosen.
 * Initialize: f(i, 0, 0) = 1, f(0, j, 0) = 0, f(0, 0, t) = 0;
 * Result: f(n, t, target), where n is the length of A
 *
 * Time Complexity: O(n*k*target).
 * Space Complexity: O(n*k*target).
 * Status: Accepted. 
 */
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        // precondition: A is not null, k is not negative, target is not neg.
        if (A == null || k < 0 || target < 0) {
            throw new IllegalArgumentException();
        }

        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];

        // init
        for (int i = 0; i <= n; i++) {
            f[i][0][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    int temp = 0;
                    if (t >= A[i - 1]) {
                        temp = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] = f[i - 1][j][t] + temp;
                }
            }
        }

        return f[n][k][target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,2,3,4};
        System.out.println(s.kSum(A, 2, 5));
    }
}

        

