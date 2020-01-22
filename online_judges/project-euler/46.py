import math
def isPerfect(a):
    s = int(math.sqrt(a))
    return s*s==a

N = 500001
prime = [True for k in range(N)]

for i in range(2,N,1):
    if prime[i]:
        for j in range(2*i,N,i):
            prime[j] = False

t = int(input())

for i in range(t):
    n = int(input())
    ans = 0
    for j in range(3,n,2):
        if prime[j] and (n - j)%2==0 and isPerfect((n - j)//2):
            #print(j, '+ 2 * ' , int(math.sqrt((n-j)//2)),'²') 
            ans += 1
    print(ans)
