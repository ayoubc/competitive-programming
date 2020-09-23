def solve(A):
    s = set()
    for x in A:
        if x != 0:
            s.add(x)
    return len(s)




t = int(input())

for i in range(t):
    N = int(input())
    A = list(map(int, input().split()))

    print(solve(A))