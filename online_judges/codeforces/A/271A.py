y = int(input())

while True:
    y+=1
    Y = str(y)
    s = set()
    for e in Y:
        s.add(e)
    if len(s)==len(Y):
        break
print(y)
