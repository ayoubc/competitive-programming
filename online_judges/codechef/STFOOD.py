def solve(N, S, V, P):
    ans = 0
    for i in range(N):
        ans = max(ans, (P[i]//S[i]) * V[i])
    return ans

t = int(input())

for i in range(t):
    N = int(input())
    S, V, P = [], [], []
    for i in range(N):
        s, p, v = map(int, input().split())
        s += 1
        S.append(s)
        P.append(p)
        V.append(v)

    print(solve(N, S, V, P))