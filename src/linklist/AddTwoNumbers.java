package linklist;

import org.omg.CORBA.INTERNAL;
import util.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.generateList(5);
        ListNode l2 = ListNode.generateList(5);
        ListNode r = addTwoNumbers(l1, l2);
        while (r != null) {
            System.out.print(r.val);
            r = r.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = buildStack(l1);
        Stack<Integer> s2 = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    public static Stack<Integer> buildStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
