def ones(s):
    b = bin(s)
    b = b[2:]
    c=0
    n = len(b)
    for i in range(n):
        if b[i]=="1":
            c+=1
    return c
t = int(input())
for k in range(t):
    a = input()
    n = len(a)
    c = 0
    for j in range(0,n,1):
        b = a[:j+1]
        if c<=ones(int(b)):
           c = ones(int(b))
    print(c)
