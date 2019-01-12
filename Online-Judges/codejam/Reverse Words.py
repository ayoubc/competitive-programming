file = open("B-large-practice.in")
output = open("B-large-practice.out","w")
i = 0
for line in file:
    if i!=0:
        ans = line.split()
        output.write("Case #{0}: ".format(i))
        res = ""
        ans = ans[::-1]
        for ele in ans:
            res += ele+" "
        #print(res)
        output.write(res+"\n")
        #print("Case #{0}:".format(i),end=' ')
        #print(*ans[::-1])
    i+=1

output.close()
