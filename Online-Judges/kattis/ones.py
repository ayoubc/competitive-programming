# Written for Python 2.7.*
import fileinput
for line in fileinput.input():
    n = int(line[:-1])
    repunit = 1
    k = 1
    while (repunit % n != 0):
        repunit *= 10
        repunit += 1
        repunit %= n # Makes computation fast
        k += 1
    print k
