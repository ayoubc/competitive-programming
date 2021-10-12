class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_histo = []
        

    def push(self, val: int) -> None:
        if self.min_histo:
            if self.min_histo[-1] >= val:
                self.min_histo.append(val)
        else:
            self.min_histo.append(val)
            
        self.stack.append(val)

    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.min_histo[-1]:
            self.min_histo.pop()
        
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_histo[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()