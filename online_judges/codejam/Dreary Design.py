#!/usr/bin/env python

import string
from collections import deque
from heapq import *


"""Math"""
def bigpow(a, n):
    acc = 1
    curPow = a*a
    while n > 0:
        if n & 1: acc *= curPow
        curPow *= curPow
        n >>= 1
    return acc
def isSquare(n): return n == int(n**.5)**2
def modpow(base, exponent, mod):
    acc = 1
    curPow = base
    while exponent > 0:
        if exponent & 1:
            acc = (acc * curBase) % mod
        curPow = (curPow * curPos) % mod
        exponent >>= 1
    return acc
def invmod(a, p): return modpow(a, p-2, p)
def choose(n, k):
    def _choose(n, r): return n * _choose(n-1, r-1) / r
    return _choose(n, min(k, n-k))
def modchoose(n, k, p):
    def _modchoose(n, r): return (n * _modchoose(n-1, r-1) * invmod(r, p)) % p
    return _modchoose(n, min(k, n-k))
phi = ((1.+5**.5)/2.)
oo = float('inf')
def fib(n): int((phi**n - (-phi)**(-n))/(5**.5))
def gcd(a, b):
    while a != b:
        if a > b: a = a - b
        else: b = b - a
    return a

"""Arrays"""
def argmin(arr):
    idx = 0
    for i, e in enumerate(arr):
        if e < arr[idx]: idx = i
    return idx

"""Bits"""
def bit(x, i): return (x & (1<<i))
def lowbit(x): (x&(x^(x-1)))

"""Strings"""
def char2int(c): return ord(c)-'0'
def alph2int(c): return ord(c)-'a' if c in string.ascii_lowercase else ord(c)-'A'

"""Grid"""
def inrange((r, c), (R, C)): return 0 <= r and r < R and 0 <= c and c < C
def traversable((r, c), ok, grid): return inrange((r, c), (len(grid), len(grid[0]))) and grid[r][c] in ok

"""Graph"""
# https://docs.python.org/2/library/heapq.html
def dijkstra(graph, source):
    def _bad_decrease_key(arr, k):
        for i, e in enumerate(arr):
            if e[1] == k[1]:
                arr[i] = k
        heapify(arr)

    N = len(graph)
    dist = [0] * N
    prev = [None] * N
    Q = []
    for i in range(N):
        if v != source:
            dist[v] = oo
            prev[v] = None
        heappush(Q, (dist[v], v))

    while Q:
        _, u = heappop(Q)
        for (v, duv) in graph[u]:
            alt = dist[u] + duv
            if alt < dist[v]:
                dist[v] = alt
                prev[v] = u
                _bad_decrease_key(Q, (alt, v))

    return (dist, prev)

def smaller(K, V):
    c = 0
    for r in range(K+1):
        for g in range(max(0, r-V), min(K, r+V)+1):
            rp = min(r, g)
            gp = max(r, g)
            smallb = max(0, gp-V)
            bigb = min(K, rp+V)
            c += abs(bigb - smallb) + 1
    return c

def small(K, V):
    end = 0
    for r in range(V):
        for g in range(r+V+1):
            rp = min(r, g)
            gp = max(r, g)
            smallb = max(0, gp-V)
            bigb = min(K, rp+V)
            end += abs(bigb - smallb) + 1
    #middle = 0
    #for g in range(2*V+1):
    #    rpp = min(V, g)
    #    gp = max(V, g)
    #    smallB = max(0, gp-V)
    #    bigB = min(K, rpp+V)
    #    middle += abs(bigB - smallB) + 1
    middle = ((V*(V-1))//2+V*V+V) + (2*V+1) + (2*V*V-(V*(V+1))//2+V)
    c = end + middle*max(0,K-2*V+1) + end
    return c

def mainCase():
    K, V = map(int, raw_input().strip().split())
    return small(K, V) if 2*V < K else smaller(K, V)

for _t in range(1, 1+int(raw_input())):
    print "Case #%d: %s" % (_t, str(mainCase()))
