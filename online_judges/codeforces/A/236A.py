name = input()

s = set()

for e in name :
    s.add(e)
ans = ""
if len(s)%2!=0:
        ans = "IGNORE HIM!"
else :
    ans = "CHAT WITH HER!"
print(ans)
