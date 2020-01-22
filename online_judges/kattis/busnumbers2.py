import math
import bisect
N = 400000
M = int(pow(N,1/3))+1
D = dict()
L = list()

for i in range(1,M):
    for j in range(i+1,M):
        x = i**3 + j**3
        if x<=N:
            if x in D:
                D[x] += 1
            else:
                D[x] = 1
                L.append(x)

L.sort()
m = int(input())
y = bisect.bisect_left(L,m)
#print(L[y])
ans= 'none'
for i in range(y,-1,-1):
    if i<len(L) and L[i]<=m and D[L[i]]>=2:
        ans = L[i]
        break

print(ans)
