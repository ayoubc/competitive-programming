import fileinput
cases = 0
for line in fileinput.input():
    N,F = line.split()
    if(int(N)==0 and int(F)==0):
        break;
    else:
        cases +=1
        S = 0
    for i in range(int(N)):
        Vitem = int(input())
        S += Vitem
    p = S//int(F)
    print("Bill #{0} costs {1}: each friend should pay {2}\n".format(cases,S,p))
    
    
