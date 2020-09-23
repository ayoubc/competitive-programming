
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)

def solve(a ,b):
    return (a * b) // gcd(a,b)

t = int(input())

for i in range(t):
    n, m = map(int, input().split())
    print(solve(n, m))