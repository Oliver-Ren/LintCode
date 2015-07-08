/* This is another approach for the wild cart matching. */
public class Solution2 {
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int lenS = s.length();
        int lenP = p.length();
        int ptrS = 0;
        int ptrP = 0;
        int snapshotS = 0;

        while (ptrS < lenS) {


            if (ptrP < lenP && p.charAt(ptrP) == '?' || 
                    s.charAt(ptrS) == p.charAt(ptrP)) {
                ptrS++;
                ptrP++;
            }

            else if (ptrP < lenP && p.charAt(ptrP) == '*') {
                ptrP++;
                
            }

            else if (ptrP < lenP && p.charAt(ptrP) != s.charAT(ptrS)) {
                ptrS++;
                ptrS = 

            }
        }

        /* Dealing with remainling strings. */
        while (ptrP < lenP && p.charAt(ptrP) == '*') {
            ptrP++;
        }

        /* 
         * The condition where the two pointers
         * are all at the end of those strings. */
        if (ptrS == lenS && ptrP == lenP) {
            return true;
        }
            

		return true;
	}
}

