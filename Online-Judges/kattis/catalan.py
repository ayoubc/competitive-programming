cat = [0]*5010
cat[0] = 1
cat[1] = 1
def catalan(n):
    if cat[n]!=0:
        return cat[n]
    else:
        cat[n] = (2*(2*n-1)*catalan(n-1))//(n+1)
    return cat[n]


q = int(input())

for i in range(q):
    x = int(input())
    cat = catalan(x)
    print(cat)
