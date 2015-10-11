/** This solution uses a greed approach.
 *  Time complexity; O(n);
 *  Space complexity: O(1);
 *  Status: Accepted, 2221ms.
 */

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int minValue = Integer.MAX_VALUE; 
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) { 
			maxProfit = Math.max(maxProfit, prices[i] - minValue);	
			minValue = Math.min(minValue, prices[i]);
		}

		return maxProfit; 

    }

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] prices = {2,1,2,0,1};
		System.out.println(test.maxProfit(prices));
	}

}

