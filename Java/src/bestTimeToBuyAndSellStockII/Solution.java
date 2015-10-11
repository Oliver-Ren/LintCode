/** This is a greedy approach. 
 * time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted, 2838ms. 
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


		int len = prices.length;
		int profit = 0;
		int low = prices[0] < prices[1] ? prices[0] : 0;
		int high = 0;

		for (int i = 1; i < len - 1; i++) {
			if (prices[i] == prices[i - 1] && prices[i] == prices[i + 1]) {
				continue;
			}
			if (prices[i] <= prices[i - 1] && prices[i] <= prices[i + 1]) {
				low = prices[i];
			} else if (prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]) {
				profit += prices[i] - low;
				low = 0;
			}
		}

		return prices[len - 1] <= prices[len - 2] ? profit : profit + prices[len - 1] - low;

    }

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] prices = {2, 1, 2, 0, 1};
		System.out.println(test.maxProfit(prices));
	}
};

