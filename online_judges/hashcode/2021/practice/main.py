import io
import time
from sys import stdin, stdout
from itertools import permutations


def timer(func):
    def wrapper(self, *args):
        start = time.perf_counter()
        result = func(self, *args)
        end = time.perf_counter()
        print(f'Execution time: {(end - start):.2f} s')
        return result

    return wrapper


class Pizza:

    def __init__(self, ingredients, size, index):
        self.ingredients = ingredients
        self.size = size
        self.index = index

    def __str__(self):
        return f'{self.size}' + ' ' + " ".join(self.ingredients)

    def __lt__(self, other):
        return self.size >= other.size


class Solution:

    def get_best_distrib(self, pizzas, first_group_sz=2):
        all_permutations = list(permutations(pizzas))
        best_score = 0
        best_perm = []
        for perm in all_permutations:
            s1 = set()
            for i in range(first_group_sz):
                s1 |= set(perm[i].ingredients)
            s2 = set()
            for i in range(first_group_sz, len(pizzas), 1):
                s2 |= set(perm[i].ingredients)

            if len(s1) ** 2 + len(s2) ** 2 > best_score:
                best_perm = perm
                best_score = len(s1) ** 2 + len(s2) ** 2

        return best_perm, best_score

    @timer
    def solve(self, M, T2, T3, T4, pizzas):
        pizzas.sort()
        ans = []
        i = 0
        while i < M:
            tmp = []
            if T4 > 0 and i + 3 < M:
                if T2 > 1:
                    s1 = set()
                    for j in range(4):
                        s1 |= set(pizzas[i + j].ingredients)

                    s2 = set()
                    for j in range(2):
                        s2 |= set(pizzas[i + j].ingredients)

                    s3 = set()
                    for j in range(2, 4, 1):
                        s3 |= set(pizzas[i + j].ingredients)

                    best_perm, best_score = self.get_best_distrib(pizzas[i:i + 4])

                    if len(s1) ** 2 > best_score:
                        tmp.append(4)
                        for j in range(4):
                            tmp.append(pizzas[i + j].index)
                        ans.append(tmp)
                        T4 -= 1
                    else:
                        ans.extend([
                            [2, best_perm[0].index, best_perm[1].index],
                            [2, best_perm[2].index, best_perm[3].index]
                        ])
                        T2 -= 2

                else:
                    tmp.append(4)
                    for j in range(4):
                        tmp.append(pizzas[i + j].index)
                    ans.append(tmp)
                    T4 -= 1
                i += 4
            elif T3 > 0 and i + 2 < M:
                tmp.append(3)
                for j in range(3):
                    tmp.append(pizzas[i + j].index)
                ans.append(tmp)
                T3 -= 1
                i += 3
            elif T2 > 0 and i + 1 < M:
                tmp.append(2)
                for j in range(2):
                    tmp.append(pizzas[i + j].index)
                ans.append(tmp)
                T2 -= 1
                i += 2
            else:
                break
        return ans


input_files = ['a', 'b', 'c', 'd', 'e']
# input_files = ['b']
sol = Solution()
for file in input_files:
    stdin = open(fr'in\{file}.in')
    stdout = open(fr'out\{file}.out', 'w')

    M, T2, T3, T4 = map(int, stdin.readline().strip('\n').split())
    pizzas = []
    for i in range(M):
        l, ings = stdin.readline().strip('\n').split(' ', 1)
        pizzas.append(Pizza(ings.split(), int(l), i))

    ans = sol.solve(M, T2, T3, T4, pizzas)
    stdout.write(f'{len(ans)}\n')
    for dilvery in ans:
        stdout.write(" ".join(map(str, dilvery)) + '\n')

# # print(out.getvalue())
