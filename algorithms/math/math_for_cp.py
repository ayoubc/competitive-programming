from math import sqrt


def factorization(n: int) -> dict:
    i = 2
    res = dict()
    while i * i <= n:
        while n % i == 0:
            res[i] = res.get(i, 0) + 1
            n //= i
        i += 1
    if n > 1:
        res[n] = res.get(n, 0) + 1
    return res


def factorize_interval(n: int) -> list:
    # this is too slow, need some improvements
    # s = time.time()
    l = [[0], [1]]
    for i in range(2, n + 1, 1):
        l.append(factorization(i))

    # e = time.time()
    # print(int(e - s) + 1)
    return l


def gcd(a: int, b: int) -> int:
    if b == 0:
        return a
    return gcd(b, a % b)


def multi_gcd(l: list) -> int:
    res = 0
    for a in l:
        res = gcd(res, a)
    return res


def lcm(a: int, b: int) -> int:
    return a * (b // gcd(a, b))


def multi_lcm(l: list) -> int:
    res = 1
    for a in l:
        res = lcm(res, a)
    return res


def extended_euclid(a, b):
    if b == 0:
        # a, x, y
        return a, 1, 0

    d, x1, y1 = extended_euclid(b, a % b)
    x = y1
    y = x1 - (a // b) * y1

    return d, x, y


def modular_inverse(a: int, n: int) -> int:
    d, x, y = extended_euclid(a, n)
    if d != 1:
        return None
    return (x + n) % n


def is_prime(n: int) -> bool:
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    q = int(sqrt(n)) + 1
    for i in range(3, q, 2):
        if n % i == 0:
            return False
    return True


def divisors(n: int) -> list:
    res = [0 for i in range(n + 1)]
    for i in range(1, n + 1, 1):
        for j in range(i, n + 1, i):
            res[j] += 1

    return res
