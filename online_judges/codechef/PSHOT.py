def solve(S, N):
    a = 0
    b = 0
    acnt = 0
    bcnt = 0
    for i in range(2 * N):
        if i % 2 == 0:
            a += int(S[i])
            acnt += 1
        else:
            b += int(S[i])
            bcnt += 1

        if a - b > N - bcnt or b - a > N - acnt:
            return i + 1
    return 2 * N


t = int(input())

for i in range(t):
    N = int(input())
    S = input()

    print(solve(S, N))
