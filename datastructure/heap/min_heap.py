class MinHeap:

    def __init__(self):
        self.heap = [0]
        self.size = 0

    def bubble_up(self, i):
        """complexity: O(log(n))"""
        # we swap current element with it's parent if the value in the parent is greater the its vallue
        while i // 2 > 0:
            if self.heap[i] < self.heap[i // 2]:
                self.heap[i], self.heap[i // 2] = self.heap[i // 2], self.heap[i]
            i = i // 2

    def push(self, val):
        """complexity: O(log(n))"""
        self.heap.append(val)
        self.size += 1
        self.bubble_up(self.size)

    def min_child(self, i):
        if i * 2 + 1 > self.size:
            return i * 2
        else:
            if self.heap[i * 2] < self.heap[i * 2 + 1]:
                return i * 2
            else:
                return i * 2 + 1

    def bubble_down(self, i):
        """complexity: O(log(n))"""
        while (2 * i) <= self.size:
            mc = self.min_child(i)
            if self.heap[i] > self.heap[mc]:
                self.heap[i], self.heap[mc] = self.heap[mc], self.heap[i]
            i = mc

    def is_empty(self):
        return self.size == 0

    def pop(self):
        """complexity: O(log(n))"""
        if self.is_empty():
            raise "Can not pop from an empty heap!"
        min_val = self.heap[1]
        self.heap[1] = self.heap[self.size]
        self.size -= 1
        self.heap.pop()
        self.bubble_down(1)
        return min_val

    # We still need to understand why this method works in O(n) !
    # sample solution to build is to insert each item from the list, but this will work in O(nlog(n))
    # def build_heap(self, alist):
    #     i = len(alist) // 2
    #     self.current_size = len(alist)
    #     self.heap = [0] + alist[:]
    #     while (i > 0):
    #         self.perc_down(i)
    #         i = i - 1

