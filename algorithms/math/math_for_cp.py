from math import sqrt, ceil, log10


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


def power(x, n):
    if n == 0:
        return 1

    tmp = power(x, n // 2)
    tmp = tmp * tmp
    if n % 2 != 1:
        tmp *= x
    return tmp


def gcd(a, b):
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


def modular_inverse(a, n):
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


def count_divisors(n: int) -> list:
    res = [0 for i in range(n + 1)]
    for i in range(1, n + 1, 1):
        for j in range(i, n + 1, i):
            res[j] += 1

    return res


def num_dig_fibo(n):
    """
    :param n:
    :return: number of digits in the n-th fibonacci number
    """
    if n == 1:
        return 1
    phi = (1 + 5 ** .5) / 2
    return ceil((n * log10(phi) - .5 * log10(5)))


def sample_sieve(limit):
    prime = [True] * (limit + 1)
    p = 2
    while p * p <= limit:
        if prime[p]:
            for j in range(p*p, limit+1, p):
                prime[j] = False
        p += 1

    return prime


def segmented_sieve(l, r):
    q = int(sqrt(r)) + 1
    mark = [True] * q
    primes = []
    for p in range(2, q):
        if mark[p]:
            primes.append(p)
            for j in range(p * p, q, p):
                mark[j] = False

    mark = [True] * (r - l + 1)
    for p in primes:
        start = max(p, (l + p - 1) // p) * p
        for j in range(start, r + 1, p):
            mark[j - l] = False
    if l == 1:
        mark[0] = False
    return mark


def chinese_reminder(a, p):
    k = len(p)
    inv = [list(range(k)) for j in range(k)]
    for i in range(k):
        for j in range(k):
            if i != j:
                inv[i][j] = modular_inverse(p[i], p[j])

    x = list(range(k))
    for i in range(k):
        x[i] = a[i]
        for j in range(i):
            x[i] = inv[j][i] * (x[i] - x[j])
            x[i] %= p[i]
            if x[i] < 0:
                x[i] += p[i]

    ans = x[0]
    prod = 1
    K = 1
    for i in range(k):
        K *= p[i]

    for i in range(1, k):
        prod *= p[i-1]
        ans += x[i] * prod
        ans %= K
    return ans


def modular_inverse_of_range(m):
    """
    To find modular inverse of numbers [1 - m-1] mod m.
    m must be a prime number. Time complexity is O(m).
    """
    inv = [i for i in range(m)]
    for i in range(2, m):
        inv[i] = m - (m // i) * inv[m % i] % m
    return inv


def phi(n):
    res = factorization(n)
    ans = 1
    for p in res:
        ans *= power(p, res[p] - 1) * (p - 1)
    return ans


def phi_2(n):
    ans = n
    i = 2
    while i * i <= n:
        if n % i == 0:
            while n % i == 0:
                n //= i

            ans -= ans // i

    if n > 1:
        ans -= ans // n
    return ans


class Point:
    EPS = 0.0001
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def __mul__(self, other):
        return self.x * other.y - self.y * other.x

    def __add__(self, other):
        return Point(self.x + other.x, self.y + other.y)

    def __sub__(self, other):
        return Point(self.x - other.x, self.y - other.y)

    def __eq__(self, other):
        return abs(self.x - other.x) <= self.EPS and abs(self.y - other.y) <= self.EPS


class Segment:
    EPS = 0.0001
    def __init__(self, points):
        self.first = Point(points[0], points[1])
        self.last = Point(points[2], points[3])

    def position_of_point(self, point):
        return (point - self.first) * (point - self.last)

    def check_common_vertex(self, other):
        return self.first == other.first or self.first == other.last \
               or self.last == other.first or self.last == other.last

    def intersect(self, other):
        cross_1 = self.position_of_point(other.first)
        cross_2 = self.position_of_point(other.last)
        a, b = self.first, self.last
        c, d = other.first, other.last

        if abs(cross_1) <= self.EPS and abs(cross_2) <= self.EPS:
            return False
        elif self.check_common_vertex(other):
            return True

        if (b - a)*(c - a)*((b- a)*(d - a)) > 0:
            return False

        a, c = c, a
        b, d = d, b
        if (b - a)*(c - a)*((b- a)*(d - a)) > 0:
            return False
        return True
