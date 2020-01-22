from math import *
import fileinput
for line in fileinput.input():
    n = int(line)
    if n==0:
        break
    else:
        somme = n
        q = int(sqrt(n))+1
        for i in range(2,q,1):
            if n%i==0:
                somme -= somme/i

            while n%i==0:
                n = n/i
        if n>1:
            somme -= somme/n
        print(int(somme))
