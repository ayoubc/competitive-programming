class Solution:
    def maxPower(self, s: str) -> int:
        n = len(s)
        ans = 0
        i = 0
        while i < n:
            j = i
            while j < n and s[j] == s[i]:
                j += 1
            ans = max(ans, j - i)
            i = j
        return ans
