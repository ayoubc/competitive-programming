
def letter(c):
    return (c>='a' and c<='z') or (c>='A' and c<='Z')

def mot(s):
    S = ""
    for e in s:
        if letter(e):
            S += e.lower()
    return S
dic = set()
while True:
    line = input()
    if line=='':
        break
    L = line.split()
    for l in L :
        dic.add(mot(l))
liste = []
for m in dic :
    liste.append(m)
liste.sort()
print(*liste,sep='\n')
