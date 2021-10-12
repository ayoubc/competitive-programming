from queue import PriorityQueue


class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        l = list(zip(efficiency, speed))
        l.sort(reverse=True)

        mod = 1000000007
        current_sum = 0
        best = 0
        pq = PriorityQueue()
        
        for e, s in l:
            if pq.qsize() < k:
                current_sum += s
                best = max(best, e * current_sum)
                pq.put(s)
            
            else:
                tmp = pq.get()
                if tmp <= s:
                    current_sum += s - tmp
                    best = max(best, e * current_sum)
                    pq.put(s)
                else:
                    # best = max(best, e * current_sum)
                    pq.put(tmp)
            
        return best % mod
        