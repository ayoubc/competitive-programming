import io
from sys import stdin

eps = 0.0000001


class Point:
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
        return abs(self.x - other.x) <= eps and abs(self.y - other.y) <= eps


class Segment:
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
        A, B = self.first, self.last
        C, D = other.first, other.last

        if abs(cross_1) <= eps and abs(cross_2) <= eps:
            return False
        elif self.check_common_vertex(other):
            return True

        if (B-A)*(C-A)*((B-A)*(D-A))>0:
            return False

        A, C = C, A
        B, D = D, B
        if (B-A)*(C-A)*((B-A)*(D-A))>0:
            return False
        return True


class Solution:
    def solve(self, n, segments):
        cnt = 0
        for i in range(n):
            for j in range(n):
                for k in range(n):
                    if segments[i].intersect(segments[j]) \
                            and segments[i].intersect(segments[k]) \
                            and segments[j].intersect(segments[k]):
                            cnt += 1

        return cnt // 6


out = io.StringIO()
sol = Solution()
points = []
n = 0
for line in stdin:
    line = line.strip('\n').split()
    if len(line) == 1:
        if len(points) != 0:
            out.write(f'{sol.solve(n, points)}\n')
            points = []
        n = int(line[0])

    else:
        points.append(Segment(list(map(float, line))))

    if n == 0:
        break

print(out.getvalue())
