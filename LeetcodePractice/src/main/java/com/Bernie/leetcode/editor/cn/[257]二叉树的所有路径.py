# 给定一个二叉树，返回所有从根节点到叶子节点的路径。 
# 
#  说明: 叶子节点是指没有子节点的节点。 
# 
#  示例: 
# 
#  输入:
# 
#    1
#  /   \
# 2     3
#  \
#   5
# 
# 输出: ["1->2->5", "1->3"]
# 
# 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
#  Related Topics 树 深度优先搜索 
#  👍 503 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
from tokenize import String
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        path = ""
        self.ans = list()

        def dfs(node: TreeNode, path: str):
            if not node:
                return None
            path = path + str(node.val)
            if not node.left and not node.right:
                self.ans.append(path)
            else:
                path = path + '->'
                dfs(node.left, path)
                dfs(node.right, path)

        dfs(root, path)

        return self.ans

# leetcode submit region end(Prohibit modification and deletion)
