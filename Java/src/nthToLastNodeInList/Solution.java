/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

/* solution using two pointers.
 * Time complexity: O(n);
 * Space complexity: O(1);
 * Status: accpted, 2599ms.
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
		ListNode fast = head;
		ListNode slow = head;
		int dist = 0;

		while (fast != null) {
			fast = fast.next;
			dist++;
			if (dist >= n && fast != null) {
				slow = slow.next;
			}
		}

		if (n > dist) {
			return null;
		}
		
		return slow;

    }
}


