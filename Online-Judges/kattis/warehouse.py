t = int(input())

for i in range(t):
    n = int(input())
    d = dict()
    for j in range(n):
        obj = input().split()
        if obj[0] in d.keys():
            d[obj[0]] += int(obj[1])
        else:
            d[obj[0]] = int(obj[1])
    L = list()
    for item in d.keys():
        L.append((item,d[item]))
    L.sort()
    L.sort(key = lambda x : x[1],reverse = True)
    print(len(L))
    for T in L:
        print(T[0],T[1])
