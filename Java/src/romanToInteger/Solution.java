/* time compleixty: O(n)
 * space compleixty: O(1)
 * status: accepted, 8205ms; 
 */

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
		int[] table = {1000, 500, 100, 50, 10, 5, 1};
		int result = 0;
		int toBeAdd = 0;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case 'M' : index = 0; break;
				case 'D' : index = 1; break;
				case 'C' : index = 2; break;
				case 'L' : index = 3; break;
				case 'X' : index = 4; break;
				case 'V' : index = 5; break;
				case 'I' : index = 6; break;
			}

			if (table[index] > toBeAdd) {
				result -= toBeAdd;
			} else {
				result += toBeAdd;
			}

			toBeAdd = table[index];
		}

		return result + toBeAdd;
    }

	public static void main(String[] args) {
		Solution test = new Solution();
		String ss = "MCMLIV";
		System.out.println(test.romanToInt(ss));
	}
}

