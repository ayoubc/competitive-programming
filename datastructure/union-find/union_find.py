class UnionFind:
    def __init__(self, N=10):
        self.id = [i for i in range(N + 1)]
        self.sz = [1] * (N + 1)

    def root(self, i):
        while i != self.id[i]:
            self.id[i] = self.id[self.id[i]]
            i = self.id[i]
        return i

    def union(self, p, q):
        i = self.root(p)
        j = self.root(q)
        if self.sz[i] <= self.sz[j]:
            self.id[i] = j
            self.sz[j] += self.sz[i]
        else:
            self.id[j] = i
            self.sz[i] += self.sz[j]

    def connected(self, p, q):
        return self.root(p) == self.root(q)
