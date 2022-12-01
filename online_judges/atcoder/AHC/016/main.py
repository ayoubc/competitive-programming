from collections import defaultdict
import random
import math

occ = defaultdict(list)


def get_n1(m, e):
    return random.randint(4, 100)


def get_n2(m, e):
    res = (1 + math.sqrt(1 + 8 * m)) / 2
    # this will make sure n(n-1)/2 >= m
    if int(res) != res:
        res = int(res) + 1
    return int(res)


def get_n3(m, e):
    return min(get_n2(m, e), 12)


def get_n4(m, e):
    res = (1 + math.sqrt(1 + 16 * (m - 1))) / 2
    if int(res) != res:
        res = int(res) + 1
    return int(res)


def get_n5(m, e):
    if e == 0:
        return get_n2(m, e)

    res = (1 + math.sqrt(1 + 8 * (m - 1) / e)) / 2
    return int(res)


def get_n6(m, e):
    if e == 0:
        return get_n2(m, e)

    res = 4
    for n in range(4, 101, 1):
        sz = (n * (n - 1)) // 2
        if int(1 / e) >= int(sz - 1 / e) + 1:
            res = max(res, n)
    return res


def get_g1(n, k, e):
    sz = (n * (n - 1)) // 2
    oes = min(sz, k)
    return '1' * oes + '0' * (sz - oes), oes


def get_g2(n, k, e):
    if e == 0:
        return get_g1(n, k, e)

    sz = (n * (n - 1)) // 2
    a = int(sz - 1 / e) + 1
    b = int(1 / e)
    oes = sz
    if a <= b:
        oes = random.randint(a, b)

    oes = min(oes, k)
    return '1' * oes + '0' * (sz - oes), oes


def reverse_flip1(H, e):
    h = list(H)

    for i in range(len(h)):
        p = 0.01 * random.randint(0, 100)
        if (p >= 1 - e and h[i] == '1') or (p <= e and h[i] == '0'):
            continue
        h[i] = chr((1 - ord(h[i]) + ord('0')) + ord('0'))

    return ''.join(h)


def reverse_flip2(H, e):
    ones = H.count('1')
    l = len(H)
    h = list(H)
    d = {'0': 0, '1': 0}
    maxes = {'0': int((l - ones) * e), '1': int(ones * e)}

    for i in range(l):
        p = 0.01 * random.randint(0, 100)
        if p < e or d[h[i]] >= maxes[h[i]]:
            continue

        d[h[i]] += 1
        h[i] = chr((1 - ord(h[i]) + ord('0')) + ord('0'))

    return ''.join(h)


def get_t1(m):
    return random.randint(0, m - 1)


def get_t2(M, H, e, graphs):
    H = reverse_flip1(H, e)

    for i in range(M):
        if graphs[i] == H:
            return i

    return min(H.count('1'), M - 1)


def get_mismatches(g1, g2):
    res = 0
    for i in range(len(g1)):
        if g1[i] != g2[i]:
            res += 1

    return res


def get_t4(M, H, e, graphs):
    ones = H.count('1')
    indexes = occ[ones]
    l = len(indexes)
    if l == 1:
        return indexes[0]

    if l > 1:
        j = random.randint(0, l - 1)
        return indexes[j]

    indexes = indexes if l > 0 else range(M - 1)

    index = -1
    error = 1
    for i in indexes:
        miss = get_mismatches(H, graphs[i])
        tmp_error = (miss / len(H)) * (1 - e)
        if tmp_error <= error:
            index = i
            error = tmp_error

    return index


def get_t5(M, H, e, graphs):
    ones = H.count('1')
    if ones < M:
        return ones

    indexes = occ[ones]
    l = len(indexes)
    if l == 1:
        return indexes[0]
    if l > 1:
        j = random.randint(0, l - 1)
        return indexes[j]

    indexes = indexes if l > 0 else range(M - 1)

    index = -1
    error = 1
    for i in indexes:
        miss = abs(ones - graphs[i].count('1'))
        tmp_error = (miss / len(H)) * (1 - e)
        if tmp_error <= error:
            index = i
            error = tmp_error

    return index


def get_t6(M, H, e, graphs):
    ones = H.count('1')
    l = len(H)
    # zeros = H.count('0')
    # to_add_o = int((ones * e * 100) / (100 - 100 * e))
    # to_add_z = int((zeros * e * 100) / (100 - 100 * e))

    if e == 0:
        return ones

    # if ones >= M:
    #     return int((e * len(H) - ones + M - 1) / 2)
    # # else:
    #
    res = int((ones - l * e) / (1 - 2 * e))
    if res < 0:
        return ones
    #
    return min(res, M-1)
    # return res


def get_t3(M, H, e, graphs):
    H = reverse_flip2(H, e)

    return get_t4(M, H, e, graphs)


def get_t7(M, H, e, graphs):
    ones = H.count('1')
    if ones < M or e == 0:
        return ones

    indexes = occ[ones]
    l = len(indexes)
    if l == 1:
        return indexes[0]
    if l > 1:
        j = random.randint(0, l - 1)
        return indexes[j]

    indexes = indexes if l > 0 else range(M - 1)

    index = -1
    diff = len(H)

    for i in indexes:
        miss = abs(ones - graphs[i].count('1'))
        if miss <= ones * e and miss <= diff:
            index = i
            diff = miss

    if index != -1:
        return index

    zeros = len(H) - ones
    for i in indexes:
        miss = abs(zeros - graphs[i].count('0'))
        if miss <= zeros * e and miss <= diff:
            index = i
            diff = miss

    return max(index, 0)


def get_t8(M, H, e, graphs):
    H = reverse_flip2(H, e)

    return get_t7(M, H, e, graphs)


def solve(n_generator, graph_generator, predictor):
    M, eps = input().split()
    M = int(M)
    eps = float(eps)

    n = n_generator(M, eps)

    print(n)
    graphs = [''] * M

    for k in range(M):
        graphs[k], o = graph_generator(n, k, eps)
        occ[o].append(k)
        print(graphs[k])

    for q in range(100):
        H = input()
        t = predictor(M, H, eps, graphs)
        print(t)


solve(get_n2, get_g1, get_t4)
