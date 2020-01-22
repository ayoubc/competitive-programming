from math import *
def Fibonacci(n):
    q=sqrt(5)
    phi = (1+q)/2
    phi_prime = (1-q)/2
    alpha = (3+q)/(2*q)
    bita = (q-3)/(2*q)
    return alpha*(phi**n)-bita*(phi_prime**n)



i = 0
s = 0
while Fibonacci(i)<4000000:
    s = s+Fibonacci(i)
    i=i+1
p = i-1
#print("le nombre recherche est:",p)
S = Fibonacci(p+2)-1
print("la somme des termes de fibonacci dont la valeur est inferieur\
a 4000000 est:",s)
print("la somme ordinaire est:",S)
