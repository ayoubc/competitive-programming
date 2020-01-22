n = int(input())
five = 0
fivePower = 5
while fivePower<=n :
    five += n//fivePower
    fivePower *= 5
two = 0
fac = 1

for i in range(1,n+1,1):
    cur = i
    while cur%5==0:
        cur //= 5
        
    while cur%2==0 and two<five:
        cur //= 2
        two += 1
    fac *= cur
    fac %= 100000
fac = str(fac)

print(fac[-3:])
 
