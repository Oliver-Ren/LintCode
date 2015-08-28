import java.util.*;

/** the first attempt for integer to roman. 
 * Status: accepted, 11169ms. 
 */

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
		char[] romanTable  = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		StringBuffer strBuffer = new StringBuffer();
		
		int scale = 1000;

		for (int i = 0; i <= 6; i+=2) {
			int digit = n / scale;  
			switch (digit) {
				case 0: break;
				case 4: strBuffer.append(romanTable[i]);
				case 5: strBuffer.append(romanTable[i - 1]); break;
				case 9: strBuffer.append(romanTable[i]);
						strBuffer.append(romanTable[i - 2]); break;
				default: 
						if (digit > 5) {
							 strBuffer.append(romanTable[i - 1]);
							 digit -= 5;
						}
						for (; digit > 0; digit--) {
							strBuffer.append(romanTable[i]);
						}
			}

			n %= scale;
			scale /= 10;
		}

		return strBuffer.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.intToRoman(1999));
	}
}

							
