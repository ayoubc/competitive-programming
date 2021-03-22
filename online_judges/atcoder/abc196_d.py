import io
from copy import deepcopy


class Solution:

    def solve(self, H, W, A, B):
        grid = []
        for i in range(W):
            grid.append([0 for k in range(H)])

        stack = [(grid, A, B)]
        ans = 0
        while len(stack) != 0:
            tmp, a, b = stack.pop()
            I, J = -1, -1
            for i in range(W):
                for j in range(H):
                    if tmp[i][j] == 0:
                        I = i
                        J = j
                        break
                if I != -1 and J != -1:
                    break

            if I == -1 and J == -1:
                if a == 0 and b == 0:
                    ans += 1
                continue

            tmp1 = deepcopy(tmp)
            tmp1[I][J] = 1
            stack.append((tmp1, a, b - 1))
            if J + 1 < H and a > 0:
                tmp1 = deepcopy(tmp)
                tmp1[I][J] = 2
                tmp1[I][J + 1] = 2
                stack.append((tmp1, a - 1, b))

            if I + 1 < W and a > 0:
                tmp1 = deepcopy(tmp)
                tmp1[I][J] = 2
                tmp1[I + 1][J] = 2
                stack.append((tmp1, a - 1, b))

        return ans


sol = Solution()
H, W, A, B = [int(x) for x in input().split()]
print(sol.solve(H, W, A, B))
