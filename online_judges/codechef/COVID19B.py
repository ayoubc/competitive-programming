
def solve(V, N):

    def initial(index):
        infected = [(index, V[index], 0.0)]
        not_yet = [(i, V[i]) for i in range(N) if i != index]

        while len(not_yet) > 0:
            tmp = []
            for i in range(len(not_yet)):
                t = 10**6
                for at in infected:
                    if (at[0] - not_yet[i][0]) * (not_yet[i][1] - at[1]) > 0:
                        cur_t = (at[0] - not_yet[i][0]) / (not_yet[i][1] - at[1])
                        if cur_t >= at[2]:
                            t = min(t, cur_t)

                if t != 10**6:
                    tmp.append((t, i))

            if len(tmp) == 0:
                break
            else:
                tmp.sort()
                # print(tmp)
                i = tmp[0][1]
                t_inf = tmp[0][0]
                infected.append((not_yet[i][0], not_yet[i][1], t_inf))
                del not_yet[i]

                # print(f'\t{len(not_yet)}')
        return len(infected)

    best = N
    worst = 1
    for i in range(N):
        inf = initial(i)
        best = min(best, inf)
        worst = max(worst, inf)

    return [best, worst]


t = int(input())

for i in range(t):
    N = int(input())
    V = list(map(int, input().split()))

    print(*solve(V, N))
