N,M,A = input().split()
n = int(N)
m = int(M)
a = int(A)
if n%a == 0:
    n = n//a
else:
    n = n//a +1
if m%a == 0:
    m = m//a
else:
    m = m//a +1
print(n*m)
