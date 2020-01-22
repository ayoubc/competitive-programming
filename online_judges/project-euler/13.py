somme = 0
with open("PE.txt") as filein:
    for line in filein:
        somme += int(line)

s = str(somme)
print(s[:10])
