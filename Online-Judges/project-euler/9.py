A = 1
B = 1
C = 1
for a in range(1,333,1):
    p = a**2
    for i in range(1,a+1,1):
        if p%i==0 and p//i>i:
            d1 = p//i
            if (d1+i)%2==0 and (d1-i)%2==0:
                c = (d1+i)//2
                b =  (d1-i)//2
                if a+b+c==1000:
                    A = a
                    B = b
                    C = c
                    break
#print(A)
#print(B)
#print(C)
print(A*B*C)
