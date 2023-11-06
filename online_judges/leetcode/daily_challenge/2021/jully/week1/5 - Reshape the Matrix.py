class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        if n * m != r * c:
            return mat
        
        l = []
        for i in range(m):
            for j in range(n):
                l.append(mat[i][j])
        
        ans = []
        for i in range(0, len(l), c):
            ans.append(l[i:i+c])
        
        return ans