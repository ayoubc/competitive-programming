# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        cur = head
        str_ = ''
        while cur is not None:
            str_ += str(cur.val)
            cur = cur.next

        return int(str_, 2)
