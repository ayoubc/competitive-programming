class Node:
    def __init__(self):
        self.is_leaf = False
        self.children = [None] * 26
        self.count = 0

class Trie:
    def __init__(self):
        self.root = Node()
        self.max_power = 0

    def get_index(self, c):
        return ord(c) - ord('a')

    def insert(self, word):
        cur = self.root
        cnt  = 0
        for i in range(len(word)-1, -1, -1):
            index = self.get_index(word[i])
            if cur.children[index] is None:
                if cur.count > 0:
                    self.max_power = max(self.max_power, cnt)
                    
                cur.children[index] = Node()
                cur.count += 1
                
            else:
                cnt += 1
            cur = cur.children[index]
        cur.is_leaf = True

        

t = int(raw_input())
trie = Trie()

for _ in range(t):
    trie.insert(raw_input())

print(trie.max_power)
