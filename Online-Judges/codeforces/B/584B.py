mod = 1000000007

def power(x,p):
    if p == 0:
        return 1
    if p == 1:
        return x%mod
    d = power(x,p//2)
    d = (d%mod * d%mod)%mod
    if p%2==1:
        d = (d%mod * x%mod)%mod
    return d


n = int(input())
ans = (power(27,n) - power(7,n))%mod

print(ans)

