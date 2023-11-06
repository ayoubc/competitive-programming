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
    public ListNode partition(ListNode head, int x) {
        ListNode ans = null;
        ListNode curAns = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (ans == null) {
                    ans = new ListNode(cur.val);
                    curAns = ans;
                }
                else {
                    curAns.next = new ListNode(cur.val);
                    curAns = curAns.next;
                }
            }
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                if (curAns == null) {
                    ans = new ListNode(cur.val);
                    curAns = ans;
                }
                else {
                    curAns.next = new ListNode(cur.val);
                    curAns = curAns.next;
                }
            }
            cur = cur.next;
        }
        return ans;
    }
}