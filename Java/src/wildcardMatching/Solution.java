package wildcardMatching;

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
		int headPtr = 0;
		int tailPtr = 0;
		int lenP = p.length();
		int lenS = s.length();


		while (headPtr < p.length() && tailPtr < s.length() && p.charAt(headPtr) != '*') {
			if (p.charAt(headPtr) == s.charAt(headPtr)
					|| p.charAt(headPtr) == '?') {
				headPtr++;
			} else {
				return false;
			}
		}

		if (headPtr == lenS) {
			return true;
		}

		while (tailPtr < p.length() && tailPtr < s.length() && p.charAt(lenP - tailPtr - 1) != '*') {
			if (p.charAt(lenP - tailPtr - 1) == s.charAt(lenS - tailPtr - 1)
				|| p.charAt(lenP - tailPtr - 1) == '?') {
				tailPtr++;
			} else {
				return false;
			}
		}

		if (headPtr == lenP - tailPtr - 1) {
			return true;
		} else {
			for (int i = 0; headPtr + i < lenS - tailPtr; i++) {
				if (isMatch(s.substring(headPtr + i, lenS - tailPtr), p.substring(headPtr + 1, lenP - tailPtr - 1))) {
					return true;
				}
			}

			return false;
		}
	}
}



			




