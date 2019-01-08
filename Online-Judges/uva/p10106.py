import fileinput

i = 1
x = 0
y = 0
for line in fileinput.input():
     if i%2==0:
         y = int(line)
         print(x*y)
     else:
         x = int(line)
     i+=1
