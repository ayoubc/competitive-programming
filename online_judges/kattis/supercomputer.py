N = 1000007
bit = [0 for k in range(N)]
a = [0 for k in range(N)]

def update(x,val,n):
    while x<=n:
        bit[x] += val
        i = x&-x
        x += i

def query(x):
    ans = 0
    while x>=1:
        ans += bit[x]
        i = x&-x
        x -= i
    return ans

n,k = input().split()
n = int(n)
k = int(k)
for i in range(k):
    L = input().split()
    if L[0] == 'F':
        index = int(L[1])
        if a[index]==1:
            a[index] = 0
            update(index,-1,n)
        else :
            a[index] = 1
            update(index,1,n)
    else :
        l = int(L[1])
        r = int(L[2])
        ans = query(r)
        if l!=1:
            ans -= query(l-1)
        print(ans)
