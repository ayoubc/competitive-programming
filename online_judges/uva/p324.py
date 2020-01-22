def factorial(n):
    p = 1
    for j in range(1,n+1,1):
        p *= j
    return p

import fileinput
for line in fileinput.input():
    n = int(line)
    if n==0:
        break
    else:
        L = list()
        D = factorial(n)
        for i in range(10):
            c = 0
            for e in str(D):
                if int(e)==i:
                    c += 1
            L.append(c)
        print("{0}! --".format(n))
        print("({0}) {1} ({2}) {3} ({4}) {5} ({6}) {7} ({8}) {9}".format(0,L[0],1,L[1],2,L[2],3,L[3],4,L[4]))
        print("({0}) {1} ({2}) {3} ({4}) {5} ({6}) {7} ({8}) {9}".format(5,L[5],6,L[6],7,L[7],8,L[8],9,L[9]))
                
