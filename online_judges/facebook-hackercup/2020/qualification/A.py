from sys import stdin, stdout
# stdin = open('in_big.txt', 'r')
# stdout = open('out_big.txt', 'w')

t = int(stdin.readline())

for k in range(t):
    n = int(stdin.readline())
    I = stdin.readline().strip('\n')
    O = stdin.readline().strip('\n')
    out = [""]*n
    for i in range(n):
        ans = ''
        if O[i] == 'N':
            ans = 'N'*i + 'Y' + 'N'*(n-i-1)
        else:
            ans = 'Y'
            j = i-1
            while j>=0 and I[j] == 'Y':
                ans = 'Y' + ans
                if O[j] == 'N':
                    break
                else:
                    j -= 1
            if j>=0 and I[j] == 'Y':
                j -= 1
            ans = 'N'*max(0, j+1) + ans

            j = i+1
            while j<n and I[j] == 'Y':
                ans += 'Y'
                if O[j] == 'N':
                    break
                else:
                    j += 1

            if j<n and I[j] == 'Y':
                j += 1
            ans += 'N'*max(0, n-j)
        out[i] = ans

    stdout.write(f'Case #{k+1}:\n')
    stdout.write('\n'.join(out) + '\n')
