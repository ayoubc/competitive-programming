import fileinput
from math import * 
newseq = True
mem = []
GL = []
comp = []
def f(i):
    global GL
    global mem
    if i==0:
        return GL[0]
    res = max(GL[i],GL[i]*f(i-1))
    return res
for line in fileinput.input():
    if newseq:
        L = list()
    cur = list(map(int,line.split()))
    if len(cur)==0:
        break
    L += cur
    if cur[-1] == -999999:
        newseq = True
        del L[-1]
        ans = -99999999999999999999999
        n = len(L)
        for i in range(n):
            p = 1
            for j in range(i,n,1):
                p *= L[j]
                ans = max(ans,p)
        print(ans)
    else :
        newseq = False
    
    
    
    
        
