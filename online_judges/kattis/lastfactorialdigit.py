t = int(input())
def fact(n):
    if n==0:
        return 1
    return fact(n-1)*n
for i in range(t):
    n = int(input())
    print(fact(n)%10)
