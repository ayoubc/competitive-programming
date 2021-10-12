from io import StringIO


class Solution:
    def __init__(self):
        self.cnt = 0
        self.arr = []

    def merge(self, start, mid, end):
        tmp = [0] * (end - start + 1)
        p, q, k = start, mid + 1, 0
        cnt = 0
        while p <= mid and q <= end:
            if self.arr[p] <= self.arr[q]:
                tmp[k] = self.arr[p]
                k += 1
                p += 1
            else:
                tmp[k] = self.arr[q]
                cnt += (mid - p + 1)
                k += 1
                q += 1

        while p <= mid:
            tmp[k] = self.arr[p]
            k += 1
            p += 1

        while q <= end:
            tmp[k] = self.arr[q]
            k += 1
            q += 1

        for p in range(start, end+1):
            self.arr[p] = tmp[p - start]

        return cnt

    def merge_sort(self, start, end):
        res = 0
        if start < end:
            middle = (end + start) // 2
            res += self.merge_sort(start, middle)
            res += self.merge_sort(middle+1, end)
            res += self.merge(start, middle, end)

        return res

    def solve(self, n, a):
        self.arr = a.copy()
        self.cnt = self.merge_sort(0, n-1)
        # print(self.arr)
        return self.cnt


out = StringIO()
sol = Solution()
# for _ in range(int(input())):
n = int(input())
a = [int(x) for x in input().split()]
out.write(f'{sol.solve(n, a)}\n')
print(out.getvalue())
