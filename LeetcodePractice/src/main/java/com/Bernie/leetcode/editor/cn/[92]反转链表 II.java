//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 796 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.Stack;

class ReverseLinkedListIi {
    public static void main(String[] args) {
        // Solution solution = new ReverseLinkedListIi().new Solution();
        System.out.println(new ReverseLinkedListIi().hammingWeight(00000000000000000000000000001011));
    }
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i=0; i< 32;i++) {
            System.out.println(1<<i);
            if ((n & (1 << i)) != 0) {
                ans ++;
            }
        }
        return ans;
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dumNode = new ListNode(-1);
            dumNode.next = head;

            // 找到left ~ right 区域的链表，截断
            // 1.找到left前的Node
            ListNode preL = dumNode;
            for (int i = 0; i < left - 1; i++) {
                preL = preL.next;
            }

            ListNode curr = preL.next;
            ListNode next;
            for (int i = 0; i < right - left; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = preL.next;
                preL.next = next;
            }
            
            /*//2.找到right节点
            ListNode rightNode = preL;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

            //3.截断链表
            ListNode leftNode = preL.next;
            ListNode successorRight = rightNode.next;

            preL.next = null;
            rightNode.next = null;

            //4.翻转截断的链表
            reverseLinkedList(leftNode);
            //5.拼接链表
            preL.next = rightNode;
            leftNode.next = successorRight;*/

            return dumNode.next;
        }

        private void reverseLinkedList(ListNode head) {
            ListNode curr = head;
            ListNode pre = null;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}