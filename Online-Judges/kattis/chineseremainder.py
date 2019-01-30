def ext_euclid(a, b):
    """(a, b) = ua + vb ; solve for u, v"""
    if b == 0:
        return (a, 1, 0)
    else:
        d, s, t = ext_euclid(b, a%b)
        return d, t, s-(a//b)*t

n = int(input())

for _ in range(n):
    a, n, b, m = [int(t) for t in input().split()]
    ggtnm, u, v = ext_euclid(n, m)
    if (b-a)%ggtnm == 0:
        K = n*m//ggtnm
        c = ((b-a)*u*n)//ggtnm + a
        print(c%K, K)
    else:
        print("no solution")
