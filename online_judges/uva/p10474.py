from bisect import *

cnt=0
while True:
    n,Q = input().split()
    n = int(n)
    Q = int(Q)
    if n==0 and Q==0:
        break
    cnt+=1
    a = input().split()
    A = [int(a[i]) for i in range(n)]
    q = [int(a[i]) for i in range(n,n+Q,1)]
    A.sort()
    print("CASE# ",cnt,":",sep='')
    for k in range(Q):
        i = bisect_left(A,q[k])
        if i==n or A[i]!=q[k]:
            print(q[k]," not found",sep='')
        else :
            print(q[k]," found at ",i+1,sep='')
