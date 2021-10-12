from typing import List


class Solution:
    def minCostToMoveChips(self, position: List[int]) -> int:
        ans = None
        n = len(position)
        for i in range(n):
            cost = 0
            for j in range(n):
                diff = abs(position[i] - position[j])
                cost += 0 if diff % 2 == 0 else 1

            if ans is None:
                ans = cost
            else:
                ans = min(ans, cost)
        return ans