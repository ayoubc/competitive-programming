/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int it = 0;
        while (true) {
            if (fast == null) return false;
            if (fast == slow && it != 0) return true;
            
            slow = slow.next;
            if (fast.next == null) return false;

            fast = fast.next.next;
            it ++;
        }
    }
}
