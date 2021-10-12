class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.is_end = False
        

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
    
    def get_index(self, c):
        c = c.lower()
        
        return ord(c) - ord('a')

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for c in word:
            index = self.get_index(c)
            if not cur.children[index]:
                cur.children[index] = TrieNode()
            
            cur = cur.children[index]
        
        cur.is_end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.root
        for c in word:
            index = self.get_index(c)
            if not cur.children[index]:
                return False
            
            cur = cur.children[index]
        
        return cur.is_end

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.root
        for c in prefix:
            index = self.get_index(c)
            if not cur.children[index]:
                return False
            
            cur = cur.children[index]
        
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
