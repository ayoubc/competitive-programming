# from sys import stdin, stdout
# stdin = open('in.txt', 'r')
# stdout = open('perimetric_chapter_1_output.txt', 'w')

def isPalindrome(x):
    s = str(x)
    return s[::-1] == s

def allPalindromeNums(a,b, N):
    allNum = []
    for i in range(a, 1000, 1):
        for j in range(b, 1000, 1):
            x = i*j
            if x < N and isPalindrome(x):
                # print(x)
                allNum.append(x)
    return allNum


a = 100
b = 100
t = int(input())
l = allPalindromeNums(a, b, 1000000)
l.sort()
l.reverse()
for i in range(t):
    n = int(input())
    for e in l:
        if e<n:
            print(e)
            break


