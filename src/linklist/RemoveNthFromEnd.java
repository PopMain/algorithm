package linklist;

import util.ListNode;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = ListNode.generateList(new int[]{1});
        ListNode result = removeNthFromEnd(listNode, 1);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
