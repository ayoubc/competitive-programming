N = 90
F = [0 for k in range(N)]
F[1] = 1
F[2] = 1
for i in range(3,N,1):
    F[i] = F[i-2] + F[i-1]
def get(i,n):
    if n==1:
        return 'N'
    if n==2:
        return 'A'
    global F
    L = F[n-2]
    if i>L:
        return get(i-L,n-1)
    else :
        return get(i,n-2)


n,k = input().split()
n = int(n)
k = int(k)

ans = get(k,min(n,89))
print(ans)



