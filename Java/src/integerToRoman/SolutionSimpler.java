import java.util.*;

/** the first attempt for integer to roman. 
 * Status: accepted, 14281ms.
 */

public class SolutionSimpler {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
		String[] romanTable = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
			"X", "IX", "V", "IV", "I"};
		int[] threshold = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuilder strBuilder = new StringBuilder();

		int index = 0;

		while (n > 0) {
			if (n >= threshold[index]) {
				strBuilder.append(romanTable[index]);
				n -= threshold[index];
			} else {
				index++;
			}
		}

		return strBuilder.toString();
	}

	
	public static void main(String[] args) {
		SolutionSimpler test = new SolutionSimpler();
		System.out.println(test.intToRoman(1999));
	}
}

							


			
