from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        length = len(nums)
        result = list()
        nums.sort()

        # 枚举第一个元素
        for first in range(length):
            if first > 0 and nums[first] == nums[first - 1]:
                continue
            # 初始化第三个循环的指针，指向最右边
            third = length - 1
            target = -nums[first]
            # 枚举第二个元素
            for second in range(first + 1, length):
                if second > first + 1 and nums[second] == nums[second - 1]:
                    continue
                while second < third and nums[third] + nums[second] > target:
                    third -= 1
                if second == third:
                    break
                if nums[second] + nums[third] == target:
                    result.append([nums[first], nums[second], nums[third]])

        return result


solution = Solution()
nums = [-1, 0, 1, 2, -1, -4]
print(nums)
print(solution.threeSum(nums))
