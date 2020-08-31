from sys import stdin, stdout
# stdin = open('perimetric_chapter_1_input.txt', 'r')
# stdout = open('perimetric_chapter_1_output.txt', 'w')
mod = 1000000007
def nextL(C_L, L1,L2):
    return ((C_L[0] * L2 + C_L[1] * L1 + C_L[2]) % C_L[3]) + 1

def nextH(C_H, H1,H2):
    return ((C_H[0] * H2 + C_H[1] * H1 + C_H[2]) % C_H[3]) + 1

def solve(N,K,W,L,H, C_L, C_H):
    P = [2 * (W + H[0])]*N
    ans = P[0]
    for i in range(1, N, 1):
        if i >= K:
            L.append(nextL(C_L, L[i-1], L[i-2]))
            H.append(nextH(C_H, H[i-1], H[i-2]))


        if L[i] > L[i-1] + W:
            # print('Here:', H[i], L[i])
            P[i] = P[i-1] + 2 * (W + H[i])
        else:
            index = i-1
            for j in range(1, W+1, 1):
                if i >= j and L[i] <= L[i - j] + W:
                    if H[index] < H[i - j]:
                        index = i - j

            if H[i] > H[index]:
                P[i] = P[index] + 2 * (H[i] - H[index]) + 2 * (L[i] - L[index])

            else:
                P[i] = P[index] + 2 * (L[i] - L[index])

        ans = ((ans % mod) * (P[i] % mod)) % mod
    # print("P: ", *P)
    # print("L: ", *L)
    # print("H: ", *H)
    return ans % mod



t = int(stdin.readline())

for k in range(t):
    N, K, W = map(int, stdin.readline().strip('\n').split())
    L = list(map(int, stdin.readline().strip('\n').split()))
    C_L = list(map(int, stdin.readline().strip('\n').split()))
    H = list(map(int, stdin.readline().strip('\n').split()))
    C_H = list(map(int, stdin.readline().strip('\n').split()))
    # print(N, K, W)
    # print(L)
    # print(C_L)
    # print(H)
    # print(C_H)

    # I = stdin.readline().strip('\n')
    # O = stdin.readline().strip('\n')
    stdout.write(f'Case #{k+1}: ')
    ans = solve(N,K,W,L,H,C_L,C_H)
    stdout.write(str(ans) + '\n')
