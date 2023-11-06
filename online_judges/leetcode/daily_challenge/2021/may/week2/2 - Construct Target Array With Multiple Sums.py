from queue import PriorityQueue


class Solution:
    def isPossible(self, target: List[int]) -> bool:
        n = len(target)
        pq = PriorityQueue()
        tot = sum(target)
        occ = [0] * 2
        for e in target:
            pq.put(-e)
            if e == 1:
                occ[1] += 1
        
        
        while True:
            if occ[1] == n:
                return True
            
            largest = pq.get()
            largest *= -1
            rest = tot - largest
            if rest <= 0:
                return False
            
            x = largest % rest
            if x == 0:
                x = rest
            if x == largest:
                return False
            
            
            tot -= largest
            tot += x
            pq.put(-x)
            if x == 1:
                occ[1] += 1
                    