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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt ++;
            cur = cur.next;
        } 
        ListNode[] ans = new ListNode[k];
        cur = head;
        int r = cnt % k;
        for(int i=0;i<k;i++) {
            ans[i] = cur;
            ListNode prev = null;
            int tmp = 0;
            int limit = k > cnt ? 1 : (cnt / k + (r > 0 ? 1 : 0));
            while(tmp < limit && cur != null) {
                tmp ++;
                prev = cur;
                cur = cur.next;
            }
            r -= 1;
            //cnt -= limit;
            if (prev != null) prev.next = null;
        }
        return ans;
    }
}