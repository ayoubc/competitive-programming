class Solution:
    def bs_1(self):
        l, r = 0, 1000
        ans = -1
        while l <= r:
            mid = (l + r) // 2
            print(f'? {mid} 0', flush=True)
            response = input()
            if response == 'YES':
                ans = mid
                l = mid + 1
            else:
                r = mid - 1

        return ans, 0

    def bs_2(self):
        l, r = 0, 1000
        ans = -1
        while l <= r:
            mid = (l + r) // 2
            print(f'? 0 {mid}', flush=True)
            response = input()
            if response == 'YES':
                ans = mid
                l = mid + 1
            else:
                r = mid - 1

        return 0, ans

    def bs_3(self, maxx):
        l, r = maxx, 1000
        ansx, ansy = -1, 2 * maxx
        while l <= r:
            mid = (l + r) // 2
            print(f'? {mid} {ansy}', flush=True)
            response = input()
            if response == 'YES':
                ansx = mid
                l = mid + 1
            else:
                r = mid - 1

        return ansx, ansy

    def solve(self):
        k = 0
        p = []
        maxx, maxy = -1, -1
        while True:
            if k >= 3:
                res = 2 * p[0][0] * p[2][1] + (p[1][1] - p[2][1]) * p[2][0]
                print(f'! {res}', flush=True)
                break

            if k == 0:
                maxx, _ = self.bs_1()
                p.append((maxx, 0))
                k += 1
            elif k == 1:
                _, maxy = self.bs_2()
                p.append((0, maxy))
                k += 1
            elif k == 2:
                p.append(self.bs_3(maxx))
                k += 1


sol = Solution()
sol.solve()
