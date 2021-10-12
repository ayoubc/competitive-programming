# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

        
class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        ans = ListNode(head.val)
        cur = head.next
        while cur is not None:
            node = ans
            prev = None
            found = False
            while node is not None:
                if node.val > cur.val:
                    found = True
                    break
                prev = node
                node = node.next

            if found:
                if prev is None:
                    tmp = ListNode(cur.val, ans)
                    ans = tmp
                else:
                    prev.next = ListNode(cur.val, node)
            else:
                prev.next = ListNode(cur.val)

            cur = cur.next

        return ans
