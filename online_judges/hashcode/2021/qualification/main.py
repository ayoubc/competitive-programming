import io
import time
from collections import deque
from queue import PriorityQueue
from sys import stdin, stdout


def timer(func):
    def wrapper(self, *args):
        start = time.perf_counter()
        result = func(self, *args)
        end = time.perf_counter()
        print(f'Execution time: {(end - start):.2f} s')
        return result

    return wrapper


class Car:
    def __init__(self, _p, _path):
        self.num_streets = _p
        self.path = _path

    def __str__(self):
        pass

    def __lt__(self, other):
        return 0


class Street:
    def __init__(self, b, e, name, l):
        self.begin = b
        self.end = e
        self.name = name
        self.len = l  # time to cross the street
        self.waiting_queue = deque()
        self.green_duration = 0

    def add_to_queue(self, _car):
        self.waiting_queue.append(_car)

    def pop(self):
        return self.waiting_queue.popleft()

    def waiting_cars(self):
        return len(self.waiting_queue)

    def __eq__(self, other):
        return self.waiting_cars() == other.waiting_cars()

    def __lt__(self, other):
        return self.waiting_cars() > other.waiting_cars()


class Intersection:
    def __init__(self, id):
        self.id = id
        self.incoming = []
        self.outcoming = []
        self.sz = None

    def add(self, street, type='in'):
        if type == 'in':
            self.incoming.append(street)
        else:
            self.outcoming.append(street)

    def size(self):
        if self.sz is None:
            self.sz = 0
            for street in self.incoming:
                self.sz += street.waiting_cars()

        return self.sz

    def get_valid_incoming(self):
        # res = 0
        # for street in self.incoming:
        #     if street.waiting_cars() > 0:
        #         res += 1
        # return res
        res = 0
        for street in self.incoming:
            if street.green_duration > 0:
                res += 1
        return res

    def __eq__(self, other):
        return self.size() == other.size()

    def __lt__(self, other):
        return self.size() > other.size()


class Solution:

    @timer
    def solve(self, D, I, S, V, F, streets, cars, intersections):
        main_inter = None
        for inter in intersections:
            if main_inter is None or inter.size() > main_inter.size():
                main_inter = inter

        q = deque()
        t = 1
        q.append(main_inter)
        vis = [False] * I
        while len(q) != 0:
            tmp_intersection = q.popleft()
            if vis[tmp_intersection.id]:
                continue

            vis[tmp_intersection.id] = True
            tmp_intersection.incoming.sort()
            for street_ in tmp_intersection.incoming:
                street_.green_duration = min(t, D)
                t += 1

            for street_ in tmp_intersection.outcoming:
                q.append(intersections[street_.end])

        res = []
        for inter in intersections:
            if inter.get_valid_incoming() > 0:
                res.append(inter)
        return res


input_files = ['a', 'b', 'c', 'd', 'e', 'f']
# input_files = ['e', 'f']
sol = Solution()
for file in input_files:
    stdin = open(fr'in\{file}.txt')
    stdout = open(fr'out\{file}.txt', 'w')

    D, I, S, V, F = map(int, stdin.readline().strip('\n').split())
    streets = []
    streets_map = {}
    inters = [Intersection(i) for i in range(I)]

    for i in range(S):
        b, e, name, l = stdin.readline().strip('\n').split(' ')
        b = int(b)
        e = int(e)
        street = Street(b, e, name, int(l))
        streets.append(street)
        streets_map[name] = street
        inters[b].add(street, 'out')
        inters[e].add(street, 'in')

    cars = []
    for i in range(V):
        p, *path = stdin.readline().strip('\n').split(' ')
        car = Car(int(p), path)
        cars.append(car)
        streets_map[path[0]].add_to_queue(car)

    ans = sol.solve(D, I, S, V, F, streets, cars, inters)
    stdout.write(f'{len(ans)}\n')
    for intersection in ans:
        stdout.write(f'{intersection.id}\n')
        stdout.write(f'{intersection.get_valid_incoming()}\n')
        for incoming in intersection.incoming:
            t = incoming.green_duration
            # if t > 0:
            stdout.write(f'{incoming.name} {t}\n')

# # print(out.getvalue())
