class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        n, m = len(matrix), len(matrix[0])
        self.aux = [[0 for i in range(m)]
        for j in range(n)]
        for i in range(0, m, 1):
            self.aux[0][i] = matrix[0][i]

        for i in range(1, n, 1):
            for j in range(0, m, 1):
                self.aux[i][j] = matrix[i][j] + self.aux[i - 1][j]

        for i in range(0, n, 1):
            for j in range(1, m, 1):
                self.aux[i][j] += self.aux[i][j - 1]


    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        res = self.aux[row2][col2]
        if col1 > 0:
            res -= self.aux[row2][col1-1]
        if row1 > 0:
            res -= self.aux[row1-1][col2]
        if row1 > 0 and col1 > 0:
            res += self.aux[row1-1][col1-1]

        return res


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)