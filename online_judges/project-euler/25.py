L = list()
L.append(1)
L.append(1)
def fibo(n):
    if n==1 or n==2:
        return 1
    elif n<=len(L):
        return L[n-1]
    else:
        K = fibo(n-1)+fibo(n-2)
        L.append(K)
        return K
n = 12
M = fibo(n)
while len(str(M))<1000:
    n+=1
    M = fibo(n)


#print(M)
#print(n)
file = open("fibo numbers(4782)","w")
for e in L:
    file.write(str(e)+"\n")
file.close()
