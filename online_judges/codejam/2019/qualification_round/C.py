from math import gcd
t = int(input())


for tt in range(1, t+1):
    n, L = map(int, input().split())
    l = list(map(int, input().split()))
    ans = [0 for k in range(L+1)]
    primes = set()
    i = 0
    while l[i] == l[0] :
        i+=1
    val = gcd(l[0], l[i])
    if i % 2 == 0 :
        ans[i] = val
        ans[0] = val
        ans[i+1] = l[i]//val
        ans[1] = l[0]//val

    else :
        ans[i] = val
        ans[1] = val
        ans[0] = l[0]//val
        ans[i+1] = l[i]//val
    primes.add(ans[0])
    primes.add(ans[1])
    primes.add(ans[i])
    primes.add(ans[i + 1])
    for k in range(i):
        if k % 2 == 0:
            ans[k] = ans[0]
        else :
            ans[k] = ans[1]
    for k in range(i+1, L, 1):
        ans[k + 1] = l[k]//ans[k]
        primes.add(ans[k+1])
    assert(len(primes) == 26)
    P = list(primes)
    P.sort()
    text =""
    for p in ans:
        index = 0
        for k in range(26):
            if P[k] == p:
                index = k
                break

        text += chr(ord('A') + index)
    print("Case #{}: {}".format(tt, text))
