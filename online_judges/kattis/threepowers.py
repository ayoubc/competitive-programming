

while True:
    n = int(input())
    if n==0:
        break
    b = bin(n-1)[2:]
    b = b[::-1]
    
    ans = str()
    for i in range(len(b)):
        if b[i]=='1':
            ans += str(pow(3,i))
            if i!=len(b)-1:
                ans += ", "
    if len(ans)!=0:
        ans = "{ "+ans+" }"
    else :
        ans = "{ }"
    print(ans)
