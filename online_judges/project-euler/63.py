
n = int(input())

for i in range(10):
    x = i**n
    if len(str(x)) == n:
        print(x)


