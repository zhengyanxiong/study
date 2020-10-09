package com.Bernie.LinkedList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create by: Bernie
 * description: 环形链表
 * create time: 2020/10/9 23:27
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CircularLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 解法1：Hash表
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while (null != head) {
            if (!nodeSet.add(head)) return true;
            head = head.next;
        }
        return false;
    }

    // 解法2：快慢指针
    public boolean hasCycle2(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (null == fast || null == fast.next){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
