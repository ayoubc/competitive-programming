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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prevNode = null;
        int first = -1;
        int cur = 0;
        int prev = -1;
        int[] ans = {-1, -1};
        while (head != null) {
            if (prevNode != null) {
                if (head.next != null) {
                    if ((prevNode.val < head.val && head.val > head.next.val)
                            ||(prevNode.val > head.val && head.val < head.next.val)) {
                        if (first == -1) first = cur;
                        else {
                            ans[1] = cur - first;
                            if (ans[0] == -1) ans[0] = cur - prev;
                            else ans[0] = Math.min(ans[0], cur - prev);
                        }
                        prev = cur;
                    }
                }
            }
            prevNode = head;
            head = head.next;
            cur++;
        }
        if(ans[0] == -1 || ans[1] == -1) ans = new int[] {-1,-1};
        return ans;
    }
}