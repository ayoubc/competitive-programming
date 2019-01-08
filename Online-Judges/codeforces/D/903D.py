n = int(input())


a = [int(x) for x in input().split()]

s = a[n-1]

ans = 0

D = dict()
D[a[n-1]] = 1

for i in range(n-2,-1,-1):
    x = a[i]
    c = 0
    d = 0
    if x-1 in D :
        c = D[x-1]
    if x+1 in D:
        d = D[x+1]
    ans += s - ((n-1-i)*x - c + d)
    s += x
    if x in D:
        D[x] += 1

    else :
        D[x] = 1

print(ans)
    
