import io


class Player:
    def __init__(self, name):
        self.name = name

    def __eq__(self, other):
        return self.name == other.name

    def __lt__(self, other):
        return self.name.lower() < other.name.lower()

    def __gt__(self, other):
        return self.name.lower() > other.name.lower()

    def __str__(self):
        return self.name


class Skill:
    def __init__(self, player, level, index):
        self.player = player
        self.level = level
        self.index = index

    def __eq__(self, other):
        return self.player == other.player and self.level == other.level

    def __lt__(self, other):
        if self.level == other.level:
            return self.player > other.player
        return self.level < other.level

    def __str__(self):
        return f'{self.player} {self.level}'


class Solution:

    def solve(self, n, skills):
        groups = []
        vis = [False] * n
        for i in range(3):
            skills[i].sort()
        i, k, j = n-1, n-1, n-1

        while True:
            while i >= 0 and vis[skills[0][i].index]:
                i -= 1
            if i >= 0:
                vis[skills[0][i].index] = True
            while j >= 0 and vis[skills[1][j].index]:
                j -= 1
            if j >= 0:
                vis[skills[1][j].index] = True
            while k >= 0 and vis[skills[2][k].index]:
                k -= 1
            if k >= 0:
                vis[skills[2][k].index] = True
            if i >= 0 and j >= 0 and k >= 0:
                groups.append([skills[0][i].player, skills[1][j].player, skills[2][k].player])
            else:
                break

        return groups


out = io.StringIO()
n = int(input())
skills = [[], [], []]
for _ in range(n):
    data = input().split()
    for i in range(3):
        skills[i].append(Skill(Player(data[0]), int(data[i+1]), _))

# for i in range(3):
#     skills[i].sort()
#
# for i in range(3):
#     for player in skills[i]:
#         print(player)
#
#     print('======================')
# print(skills)
sol = Solution()
ans = sol.solve(n, skills)
for group in ans:
    tmp = group
    tmp.sort()
    print(*tmp)
