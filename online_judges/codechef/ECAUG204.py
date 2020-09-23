def solve(l):
    d = {}
    for x in l:
        if x in d:
            return "No"
        d[x] = 1

    return "Yes"

t = int(input())

for i in range(t):
    n = int(input())
    L = list(map(int, input().split()))
    print(solve(L))