/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        int sz = 0;
        ListNode* curr = head;
        while(curr != nullptr) {
            sz ++;
            curr = curr->next;
        }
        int cnt=1;
        ListNode* ans = head;
        while(1){
            if(cnt == (sz+2)/2) break;
            cnt++;
            ans = ans->next;
        }
        //cout << ans->val << endl;
        return ans;
    }
};