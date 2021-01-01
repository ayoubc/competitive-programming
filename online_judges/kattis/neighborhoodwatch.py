import io


class Solution:

    def solve(self, n, k, h):
        unsafe = []
        for i in range(k):
            if i == 0:
                unsafe.append(h[i] - 1)
            else:
                unsafe.append(h[i] - h[i - 1] - 1)

            if i == k-1:
                unsafe.append(n - h[-1])

        squqres = 0
        sum = 0
        for val in unsafe:
            sum += val
            squqres += val * val
        return (sum ** 2 - squqres)//2 + k + k * (k - 1) // 2 + k * (n - k)


out = io.StringIO()
n, k = map(int, input().split())
h = []
for _ in range(k):
    h.append(int(input()))
sol = Solution()
print(sol.solve(n, k, h))