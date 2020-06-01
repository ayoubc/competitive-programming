def f(n):
    if n==0 or n==1:
        return 1
    return n * f(n-1)

t = int(input())

for i in range(t):
    n = int(input())
    if n >= 5:
        ans = 0
    else:
        ans = f(n)%10
    print(ans)
