/** This solution uses the though of 
 *  binary serach.
 *  time complexity: O(logn);
 *  space complexity: O(1);
 *  status: Accepted, 1447ms. 
 */

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
		if (A == null || A.length == 0) {
			return 0;
		}

		

		int left = 1;
		int right = A.length - 2;
		
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (A[mid - 1] < A[mid]) {
				left = mid;
			} else if (A[mid - 1] > A[mid]) {
				right = mid - 1;
			}
		
		}

		return A[left] > A[right] ? left : right;
    }

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] A = {1, 2, 1, 3, 4, 5, 7 ,6};
		System.out.println(test.findPeak(A));
	}
}


