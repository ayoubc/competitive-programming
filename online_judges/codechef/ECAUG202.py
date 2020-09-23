
def solve(l):
    ans = 0
    for x in L:
        if x % 2 == 0:
            ans += x
    return ans

t = int(input())

for i in range(t):
    n = int(input())
    L = list(map(int, input().split()))
    print(solve(L))