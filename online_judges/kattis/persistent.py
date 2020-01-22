import fileinput


for line in fileinput.input():
    n = int(line)
    L = list()
    if n==-1:
        break
    if n==1:
        print(11)
    elif n==0:
        print(10)
    elif n<=9:
        st = "1"+str(n)
        print(st)
    else:
        for i in range(9,1,-1):
            while n%i==0 :
                L.append(i)
                n //= i
        if n!=1:
            print("There is no such number.")
        else:
            L.sort()
            st = ""
            for k in L:
                st += str(k)
            print(st)
