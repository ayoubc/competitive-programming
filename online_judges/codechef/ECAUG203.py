from math import sqrt
def solve(N):

    return int(sqrt(N/2)) * 2


t = int(input())

for i in range(t):
    N = int(input())
    print(solve(N))