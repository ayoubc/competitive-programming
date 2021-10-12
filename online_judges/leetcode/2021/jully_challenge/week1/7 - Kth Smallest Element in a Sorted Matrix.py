class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        cnt = 0
        n = len(matrix)
        l = []
        for i in range(n):
            for j in range(n):
                l.append(matrix[i][j])  
        
        l.sort()
        return l[k-1]