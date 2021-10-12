# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        a = self.getVal(l1)
        b = self.getVal(l2)
        return self.constructListNode(a + b)
    
    def getLen(self, l: ListNode) -> ListNode:
        ans = 0
        cur = l
        while cur is not None:
            ans += 1
            cur = cur.next
        return ans
    
    def getVal(self, l: ListNode) -> ListNode:
        ans = 0
        n = self.getLen(l) - 1
        cur  = l
        while cur is not None:
            ans += cur.val * 10 ** (n)
            n -= 1
            cur = cur.next
        return ans
    
    def constructListNode(self, num):
        if num == 0:
            return ListNode(0)
        tmp = []
        while num > 0:
            tmp.append(num % 10)
            num //= 10
        
        n = len(tmp)
        head = ListNode(tmp[n - 1])
        ans = head
        for i in range(n - 2, -1, -1):
            ans.next = ListNode(tmp[i])
            ans = ans.next
        
        return head
