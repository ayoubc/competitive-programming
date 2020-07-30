def check_arithmitic(l):
    diff = l[1] - l[0]
    for i in range(2, len(l), 1):
        if diff != l[i] - l[i-1]:
            return False
    return True

def check_premuted_arithmetic(l):
    l.sort()
    return check_arithmitic(l)


n = int(input())

for i in range(n):
    l = list(map(int, input().split()))
    ans = 'non-arithmetic'
    if check_arithmitic(l[1:]):
        ans = 'arithmetic'
    elif check_premuted_arithmetic(l[1:]):
        ans = 'permuted arithmetic'
    print(ans)