#import fileinput
#for line in fileinput.input():
from sys import stdin
for line in stdin:
    if not line:
        break
    s = line[:-1]
    ans = ""
    i = 0
    while i<len(s):
        if s[i]=='[':
            j = i+1
            cur=""
            while j<len(s) and s[j]!='[' and s[j]!=']':
                cur += s[j]
                j+=1
                ans = cur + ans
                i = j
        elif s[i]==']':
            j = i+1
            cur=""
            while j<len(s) and s[j]!='[' and s[j]!=']':
                cur += s[j]
                j+=1
                ans = ans + cur
                i = j
        else :
            ans += s[i]
            i+=1
    print(ans)
