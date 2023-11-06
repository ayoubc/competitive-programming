class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        pre_sum = [0] * n
        pre_sum[0] = cardPoints[0]
        for i in range(1, n):
            pre_sum[i] = pre_sum[i-1] + cardPoints[i]
        
        ans = 0
        for i in range(k+1):
            x = pre_sum[n-k-1+i]
            if i > 0:
                x -= pre_sum[i-1]
            ans = max(ans, pre_sum[n-1] - x)
        
        return ans