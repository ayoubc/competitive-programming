class Node:
    def __init__(self, val, nxt=None, prev=None):
        self.val = val
        self.next = nxt
        self.prev = prev
        

class DoublyLinkedList:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.len = 0
            
    def get(self, index: int) -> int:
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        """
        if index >= self.len:
            return -1
        
        cur = self.head
        for i in range(index):
            cur = cur.next
        
        return cur.val
        
    def addAtHead(self, val: int) -> None:
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        """
        old = self.head
        
        self.head = Node(val)
        self.head.next = old
        if old:
            old.prev = self.head
        
        self.len += 1
        
    def addAtTail(self, val: int) -> None:
        """
        Append a node of value val to the last element of the linked list.
        """
        if self.head is None:
            self.addAtHead(val)
            return 
        
        cur = self.head
        while cur.next is not None:
            cur = cur.next
            
        cur.next = Node(val, None, cur)
        self.len += 1
        
    def addAtIndex(self, index: int, val: int) -> None:
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        """
        if index > self.len:
            return
        
        if index == 0:
            self.addAtHead(val)
            return
        
        if index == self.len:
            self.addAtTail(val)
            return
        
        cur = self.head
        for i in range(index-1):
            cur = cur.next
        
        new_node = Node(val, cur.next, cur)
        if cur.next:
            cur.next.prev = new_node
        cur.next = new_node
        
        self.len += 1
        
    def deleteAtIndex(self, index: int) -> None:
        """
        Delete the index-th node in the linked list, if the index is valid.
        """
        if index >= self.len:
            return
        
        if index == 0:
            self.head = self.head.next
            if self.head:
                self.head.prev = None
        
        else:
            cur = self.head
            for i in range(index-1):
                cur = cur.next
            
            next_node = cur.next.next
            cur.next = next_node
            if next_node:
                next_node.prev = cur
        self.len -= 1

# Your DoublyLinkedList object will be instantiated and called as such:
# obj = DoublyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
