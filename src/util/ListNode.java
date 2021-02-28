package util;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode generateList(int...vales) {
        ListNode head = new ListNode(vales[0]);
        ListNode cur = head;
        for (int i = 1; i < vales.length; i++) {
            ListNode listNode = new ListNode(vales[i]);
            cur.next = listNode;
            cur = listNode;
        }
        return head;
    }
}
