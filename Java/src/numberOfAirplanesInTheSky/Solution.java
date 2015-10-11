import java.util.*;
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

/**
 * My first attempt.
 * My idea is to keep two sorted lists, one for start time
 * and one for end time. then do the operation like merge.
 * if start time is chosen, onTheSky + 1, if the end time
 * is chose, onTheSky - 1;
 * Time complexity: O(nlogn) + O(n) = O(nlogn)
 * Space complexity: O(n);
 * Status: 
 */
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // precondition: airplances is not null
        if (airplanes == null) {
            return 0;
        }
        
        int len = airplanes.size();
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i < len; i++) {
            starts[i] = airplanes.get(i).start;
            ends[i] = airplanes.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int pStart = 0;
        int pEnd = 0; 
        int currOnTheSky = 0;
        int maxOnTheSky = 0;

        while (pStart < len && pEnd < len) {
            if (starts[pStart] < ends[pEnd]) {
                pStart++;
                currOnTheSky++;
            } else {
                pEnd++;
                currOnTheSky--;
            }
            maxOnTheSky = Math.max(currOnTheSky, maxOnTheSky);
        }

        return maxOnTheSky;
    }
}

