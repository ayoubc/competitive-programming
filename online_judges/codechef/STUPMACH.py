def solve(S, N):

    T = [(S[i], i) for i in range(N)]
    T.sort(key=lambda v: v[0])
    rigth  = T[0][1]
    value = T[0][0]
    ans = value * N
    for i in range(1, N, 1):
        if T[i][1] <= rigth:
            ans += (T[i][0] - value) * rigth
            value = T[i][0]
            rigth = T[i][1]
    return ans


t = int(input())

for i in range(t):
    N = int(input())
    S = list(map(int, input().split()))

    print(solve(S, N))