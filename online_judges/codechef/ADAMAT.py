def solve(M, N):

    def check():
        for i in range(N-1, -1, -1):
            for j in range(N-1, -1, -1):
                # print(M[i][j], end=' ')
                if M[i][j] != i * N + j + 1:
                    return max(i, j) + 1

            # print()
        return -1

    def transpose(L):
        for i in range(L):
            for j in range(i+1):
                M[i][j], M[j][i] = M[j][i], M[i][j]

    ans = 0
    while True:
        L = check()
        if L == -1:
            break
        transpose(L)
        ans += 1

    return ans



t = int(input())

for i in range(t):
    N = int(input())
    M = []
    for i in range(N):
        M.append(list(map(int, input().split())))


    print(solve(M, N))
