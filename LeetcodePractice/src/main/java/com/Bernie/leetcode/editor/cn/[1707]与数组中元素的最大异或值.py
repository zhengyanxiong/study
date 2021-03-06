# 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。 
# 
#  第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR
#  xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。 
# 
#  返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个
# 查询的答案。 
# 
#  
# 
#  示例 1： 
# 
#  输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
# 输出：[3,3,7]
# 解释：
# 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
# 2) 1 XOR 2 = 3.
# 3) 5 XOR 2 = 7.
#  
# 
#  示例 2： 
# 
#  输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
# 输出：[15,-1,5]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length, queries.length <= 105 
#  queries[i].length == 2 
#  0 <= nums[j], xi, mi <= 109 
#  
#  Related Topics 位运算 字典树 
#  👍 57 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Trie:
    L = 30

    def __init__(self):
        self.left = None
        self.right = None

    def insert(self, val: int):
        node = self
        for i in range(Trie.L, -1, -1):
            bit = (val >> i) & 1
            if bit == 0:
                if not node.left:
                    node.left = Trie()
                node = node.left
            else:
                if not node.right:
                    node.right = Trie()
                node = node.right

    def getMaxXor(self, val: int) -> int:
        ans, node = 0, self
        for i in range(Trie.L, -1, -1):
            bit = (val >> i) & 1
            check = False
            if bit == 0:
                if node.right:
                    node = node.right
                    check = True
                else:
                    node = node.left
            else:
                if node.left:
                    node = node.left
                    check = True
                else:
                    node = node.right
            if check:
                ans |= 1 << i
        return ans


class Solution:
    def maximizeXor(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        n, q = len(nums), len(queries)
        nums.sort()
        queries = sorted([(x, m, i) for i, (x, m) in enumerate(queries)], key=lambda query: query[1])

        ans = [0] * q
        trie = Trie()
        idx = 0
        for x, m, qid in queries:
            while idx < n and nums[idx] <= m:
                trie.insert(nums[idx])
                idx += 1

            if idx == 0:
                # 字典树为空
                ans[qid] = -1
            else:
                ans[qid] = trie.getMaxXor(x)

        return ans

# leetcode submit region end(Prohibit modification and deletion)
