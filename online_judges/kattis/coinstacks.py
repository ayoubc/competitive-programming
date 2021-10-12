import sys
sys.setrecursionlimit(10 ** 6)
class Solution:
    def solve(self, n, a):
        def inner(n, cura, steps):
            ok = True
            for i in range(n):
                if cura[i] != 0:
                    ok = False
                    break
            if ok:
                print("yes")
                for u, v in steps:
                    print(u, v)
                    
                return True

            m1index = 0
            for i in range(n):
                if cura[i] > cura[m1index]:
                    m1index = i

            m2index = -1
            for i in range(n):
                if i == m1index:
                    continue
                if m2index == -1:
                    m2index = i
                    
                elif cura[i] > cura[m2index]:
                    m2index = i
                    
            if cura[m1index] > 0 and cura[m2index] > 0:
                cura[m1index] -= 1
                cura[m2index] -= 1
                if inner(n, cura, steps+[(m1index+1, m2index+1)]):
                    return True
                    
                cura[m1index] += 1
                cura[m2index] += 1      
            return False
        ans = inner(n, a, [])
        if not ans:
            print('no')
n = int(input())
a = list(map(int, input().split()))
sol = Solution()
sol.solve(n, a)
