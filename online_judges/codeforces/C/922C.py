n, k = map(int, input().split())

if k > 70:
    print('No')
    exit(0)

s = set()
for i in range(1, k + 1):
    s.add(n % i)

print('Yes' if len(s) == k else 'No')
