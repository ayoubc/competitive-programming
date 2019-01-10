from os import *

i = 3
S = 0

while i<=1000:
    if i%3 == 0 or i%5 == 0:
       
        S=S+i
    i=i+1
    print("S devient:",S)
    print("i deveint :",i)

os.system("pause")


