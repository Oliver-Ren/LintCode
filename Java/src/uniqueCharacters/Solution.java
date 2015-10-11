/** As we are required not to use any 
 *  date structures, we could sort the array.
 *  time complexity: O(nlogn).
 *  space complexity: O(logn).
 *  Status: Accepted, 1676ms.
 */

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
		char[] s = str.toCharArray();
		Arrays.sort(s);
		for (int i = 1; i < s.length; i++) {
			if (s[i] == s[i - 1]) {
				return false;
			}
		}

		return true;
			
    }
}

