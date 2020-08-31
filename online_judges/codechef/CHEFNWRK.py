
def solve(K, W):
    curW = 0
    ans = 0
    i = 0
    for w in W:
        if w + curW <= K:
            curW += w
        else:
            if w > K:
                return -1
            else:
                curW = w
                ans +=1
    return ans+1

t = int(input())

for i in range(t):
    n,k = map(int, input().split())
    w = list(map(int, input().split()))
    print(solve(k, w))


