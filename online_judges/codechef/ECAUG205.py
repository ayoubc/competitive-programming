def solve(K, L):

    def ok(x):
        tot = 0
        for i in L:
            tot += i // x
        return tot >= K

    l, r = 1, 10**18
    ans = 0
    while l <= r:
        mid = (l + r)//2
        if ok(mid):
            l = mid + 1
            ans = mid
        else:
            r = mid - 1
    return ans

t = int(input())

for i in range(t):
    N, K = map(int, input().split())
    L = list(map(int, input().split()))
    print(solve(K, L))