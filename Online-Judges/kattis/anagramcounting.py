import fileinput
def occurence(S,c):
    i = 0
    for ele in S:
        if ele == c:
            i +=1
    return i
def fac(n):
    if n==0:
        return 1
    if n==1:
        return 1
    return n*fac(n-1)




for anagram in fileinput.input():
    n = len(anagram)
    tab = str()
    resultat = fac(n-1)
    for ele in anagram:
        if occurence(tab,ele) == 0:
            tab = tab +ele
            j = occurence(anagram,ele)
            resultat = resultat//fac(j)
    print(resultat)

