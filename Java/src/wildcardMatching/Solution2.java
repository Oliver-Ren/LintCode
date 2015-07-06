package wildcardMatching;
/* This is the greedy approach for the wild cart matching. */
public class Solution2 {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
            return false;
        }
        
        int lenS = s.length();
        int lenP = p.length();
        int ptrS = 0;
        int ptrP = 0;
        int snapshotP = -1;
        int snapshotS = -1;

        while (ptrS < lenS && ptrP < lenP) {

            if (p.charAt(ptrP) == '?' || 
                    s.charAt(ptrS) == p.charAt(ptrP)) {
                ptrS++;
                ptrP++;
            }

            else if (p.charAt(ptrP) == '*') {
                ptrP++;
                snapshotP = ptrP;
                snapshotS = ptrS;
            }

            else if (p.charAt(ptrP) != s.charAt(ptrS) && snapshotP >= 0) {
                ptrS = ++snapshotS;
                ptrP = snapshotP;
            } else {
                return false;
            }
        }

        /* Dealing with remainling stars. */
        while (ptrP < lenP && p.charAt(ptrP) == '*') {
            ptrP++;
        }

        if (ptrS < lenS && p.charAt(lenP - 1) == '*') {
            ptrS = lenS;
        }

        /* 
         * The condition where the two pointers
         * are all at the end of those strings. */
        if (ptrS == lenS && ptrP == lenP)  {
            return true;
        }
            

		return false;
	}
}

