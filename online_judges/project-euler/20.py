def factorial(n):
    p = 1
    for i in range(1,n+1,1):
        p *= i
    return p

somme=0
for d in str(factorial(100)):
    somme += int(d)

print(somme)
