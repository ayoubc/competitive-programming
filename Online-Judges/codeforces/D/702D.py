d,k,a,b,t = [int(s) for s in input().split()] 

ans = d*b
n = d//k

if d<=k:
    ans = ans = d*a
elif t+a*k>k*b :
    ans = k*a + (d - k)*b
else :
    ans = n*k*a + (n-1)*t + min(t + (d%k)*a , (d%k)*b)
print(ans)
