def mod_pow(a,p,mod):
    if p==1:
        return a%mod
    elif p%2==0:
        d = mod_pow(a,p//2,mod)
        return (d%mod)*(d%mod)
    else:
        d = mod_pow(a,(p-1)//2,mod)
        return (a%mod)*(d%mod)*(d%mod)
    
som = 0
for i in range(1,1001,1):
    som += mod_pow(i,i,10000000000000)

print(som%10000000000)
