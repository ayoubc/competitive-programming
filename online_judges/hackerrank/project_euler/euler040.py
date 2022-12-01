import io


class Solution:
    
    def get_digit(self, n):
        k = 0
        included = True
        while True:
            length = 9 * (k + 1) * 10 ** k
            if n > length:
                included = False
                n -= length
                k += 1
            else:
                break
        
        left = 10 ** k
        number = left + (n // (k + 1))
        if n % (k + 1) == 0:
            number -= 1

        number = str(number)
        index = n % (k + 1) - 1
        #print(number)
        #print(n, k+1)
        return int(number[index])

   
    def solve(self, iss):
        p = 1

        for i in iss:
        
            d = self.get_digit(i)
            p *= d
        
        return p


t = int(input())
out = io.StringIO()
sol = Solution()
for tc in range(t):
    iss = list(map(int, input().split()))
    out.write(str(sol.solve(iss)) + '\n')

print(out.getvalue())
