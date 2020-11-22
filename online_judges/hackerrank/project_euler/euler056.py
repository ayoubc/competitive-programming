#import time
n = int(input())
ans = 0
for a in range(2,n,1):
    for b in range(1,n,1):
        x = a**b
        s = 0
        STR = str(x)
        for d in STR:
            s += int(d)
        ans = max(ans,s)
print(ans)
