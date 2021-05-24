# 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
# 
#  
# 
#  示例： 
# 
#  输入：
# 
#    1
#     \
#      3
#     /
#    2
# 
# 输出：
# 1
# 
# 解释：
# 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中至少有 2 个节点。 
#  本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
# 相同 
#  
#  Related Topics 树 
#  👍 254 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import sys
from cmath import inf


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        ans, pre = sys.maxsize, -1
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop(-1)
            if pre != -1:
                ans = min(ans, root.val - pre)
            pre = root.val
            root = root.right
        return ans


print(float(-inf))
# leetcode submit region end(Prohibit modification and deletion)
