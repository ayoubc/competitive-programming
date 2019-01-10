def power(x,n):
    if n==1:
        return x
    elif n%2==0:
        d = power(x,n//2)
        return d*d
    else:
        d = d = power(x,(n-1)//2)
        return x*d*d
s = power(2,1000)
somme = 0
S = str(s)
for i in S:
    somme += int(i)
print(somme)
