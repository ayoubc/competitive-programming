class Solution:
    def countPrimes(self, n: int) -> int:
        is_prime = [True] * n
        cnt = 0
        for i in range(2, n):
            if is_prime[i]:
                cnt += 1
                for j in range(i * i, n, i):
                    is_prime[j] = False
        
        return cnt