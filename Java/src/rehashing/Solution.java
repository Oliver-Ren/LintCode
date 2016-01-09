/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Status: Accepted.
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        // preconditon: hashTable is not null
        if (hashTable == null) throw new NullPointerException();
       
        int n = hashTable.length;
        ListNode[] newHashTable = new ListNode[2 * n];

        for (ListNode head : hashTable) {
            ListNode curr = head;
            while (curr != null) {
                int newIndex = hashcode(curr.val, 2 * n); 
                if (insPoint == null) {
                    insPoint = new ListNode(curr.val);
                } else {
                    ListNode insPoint = newHashTable[newIndex];
                    while (insPoint.next != null) {
                        insPoint = insPoint.next;
                    }
                    insPoint.next = new ListNode(curr.val);
                }
            }

            curr = curr.next;
        }

        return newHashTable;

    }

    private int hashcode(int key, int capacity) {
        return (key % capacity + capacity) % capacity;
    }
};

