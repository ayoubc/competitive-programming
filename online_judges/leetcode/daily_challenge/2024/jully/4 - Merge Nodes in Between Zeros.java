/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = null;
        ListNode curNode = null;
        head = head.next;
        int cur = 0;
        while (head != null) {
            if (head.val == 0) {
                ListNode tmp = new ListNode(cur);
                if (result == null) {
                    result = tmp;
                    curNode = tmp;
                }
                else {
                    curNode.next = tmp;
                    curNode = curNode.next;
                }
                cur = 0;
            }
            else cur += head.val;
            head = head.next;
        }
        return result;
    }
}