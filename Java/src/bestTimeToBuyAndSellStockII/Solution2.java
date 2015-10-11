/** This is a greedy approach. 
 * time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted, 3273ms. 
 */

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int diff = 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			diff = prices[i] - prices[i - 1];
			if (diff > 0 ) {
				profit += diff;
			}
		}

		return profit;
	}
}

