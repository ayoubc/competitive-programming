import io
# import fileinput
# for line in fileinput.input()


# out = io.StringIO()
t = int(input())
ans = []
for tc in range(t):
    a = list(map(int, input().split()))
    res = 0
    for x in a:
        res |= x
    ans.append(res)

print(*ans)
