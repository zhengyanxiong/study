from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = list()
        if n < 1 or n > 20:
            return res
        allNums = n * n
        res = [[0 for col in range(n)] for row in range(n)]
        left, top, right, bottom, num = 0, 0, n - 1, n - 1, 1
        while num <= allNums:
            # left -> right
            for column in range(left, right + 1):
                res[left][column] = num
                num = num + 1
            top = top + 1
            # top -> bottom
            for column in range(top, bottom + 1):
                res[column][right] = num
                num = num + 1
            right = right - 1
            # right -> left
            for column in range(right, left - 1, -1):
                res[bottom][column] = num
                num = num + 1
            bottom = bottom - 1
            # bottom ->  top
            for column in range(bottom, top - 1, -1):
                res[column][left] = num
                num = num + 1
            left = left + 1
        return res

solution = Solution()

multilist = solution.generateMatrix(3)

print(multilist)