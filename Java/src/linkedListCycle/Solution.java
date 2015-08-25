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

/** This is the solution using fast and slow pointers.
 * time complexity: O(n);
 * space complexity: O(1);
 * status: accpted, 2167ms.
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
		if (head == null || head.next == null) {
			return false;
		}

		ListNode fast = head;
		ListNode slow = head;


		while (true) {
			if (fast == null || fast.next == null) {
				return false;
			}

			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}
			
    }
}
 
