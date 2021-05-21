from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = list()
        if not matrix or not matrix[0]:
            return ans
        row, columns = len(matrix), len(matrix[0])
        left, right, top, bottom = 0, columns - 1, 0, row - 1
        while left <= right and top <= bottom:
            # 从左到右
            for column in range(left, right + 1):
                ans.append(matrix[top][column])
            # 从上到下
            for row in range(top + 1, bottom + 1):
                ans.append(matrix[row][right])
            if left < right and top < bottom:
                # 从右向左
                for column in range(right - 1, left - 1, -1):
                    ans.append(matrix[bottom][column])
                # 从下往上
                for row in range(bottom - 1, top, -1):
                    ans.append(matrix[row][left])

            left, right, top, bottom = left + 1, right - 1, top + 1, bottom - 1

        return ans


solution = Solution()
ans = solution.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print(ans)

