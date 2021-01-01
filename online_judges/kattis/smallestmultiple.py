import fileinput

def gcd(a,b):
    if b==0 :
        return a
    return gcd(b,a%b)


for line in fileinput.input():
    L = line.split()
    ans = 1
    for elm in L:
        a = int(elm)
        ans = (ans*a)//gcd(a,ans)
    print(ans)