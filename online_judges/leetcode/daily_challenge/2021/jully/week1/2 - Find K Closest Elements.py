
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = [(abs(e-x), e) for e in arr]
        l.sort()
        return sorted([l[i][1] for i in range(len(arr)) if i < k])
    
            