while True :
    n = int(input())
    if n==0 :
        break
    L = [0 for k in range(n)]
    M = 0;
    for i in range(n):
        s = input()
        for j in range(25):
            if s[j]=='X':
                L[i] += 1
        M = max(M,L[i])
    ans = 0
    for i in range(n):
        ans = ans + M - L[i]
    print(ans)
