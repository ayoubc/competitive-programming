from collections import deque
from typing import List


class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 2:
            return [i for i in range(n)]

        tree = [[] for i in range(n)]
        degree = [0 for i in range(n)]
        for edge in edges:
            a, b = edge
            tree[a].append(b)
            tree[b].append(a)
            degree[a] += 1
            degree[b] += 1

        q = deque()

        for i in range(n):
            if degree[i] == 1:
                q.append(i)

        while n > 2:
            sz = len(q)
            n -= sz

            for i in range(sz):
                a = q.popleft()
                for node in tree[a]:
                    degree[node] -= 1
                    if degree[node] == 1:
                        q.append(node)

        return list(q)
