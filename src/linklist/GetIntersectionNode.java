package linklist;

import util.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
