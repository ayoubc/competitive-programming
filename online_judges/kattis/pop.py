from math import sqrt


class Point:
    def __init__(self, *args):
        self.x,  self.y, self.z = args

    def distance(self, other):
        return (other.x - self.x) ** 2 + (other.y - self.y) ** 2 + (other.z - self.z) ** 2


class Vector:
    def __init__(self, *args):
        self.p = Point(*args[:3])
        self.x, self.y, self.z = args[3:]


class Sphere:
    def __init__(self, r, s, x, y):
        self.r = r
        self.x = x
        self.y = y
        self.z = s + r

    def intersection(self, vector: Vector):
        a = vector.x ** 2 + vector.y ** 2 + vector.z ** 2
        b = 2 * (vector.x * (vector.p.x - self.x) + vector.y * (vector.p.y - self.y) + vector.z * (vector.p.z - self.z))
        c = (vector.p.x - self.x) ** 2 + (vector.p.y - self.y) ** 2 + (vector.p.z - self.z) ** 2 - self.r ** 2
        delta = b ** 2 - 4 * a * c
        if delta <= 0:
            return None

        u = (sqrt(delta) - b) / (2 * a)
        if u < 0:
            return None
        return (u * vector.x) ** 2 + (u * vector.y) ** 2 + (u * vector.p.z) ** 2

        #return Point(u * vector.p.x, u * vector.p.y, u * vector.p.z)



while True:
    n = int(input())
    if n == 0:
        break

    ballons = []
    for i in range(n):
        r, s, x, y = [float(_) for _ in input().split()]
        ballons.append(Sphere(r, s, x, y))

    m = int(input())
    vis = [False] * n
    ans = [0] * m

    for i in range(m):
        v = Vector(*[float(_) for _ in input().split()])
        for j in range(n):
            ballon = ballons[j]
            d = ballon.intersection(v)
            if d is not None and not vis[j]:
                vis[j] = True
                ans[i] += 1

    print(*ans, sep='\n')
