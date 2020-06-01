n = int(input())
ans = 0
l = list(map(int, input().split()))
for x in l:
    ans ^= x
print(ans)
