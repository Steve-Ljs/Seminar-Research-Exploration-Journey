package hot;

import utils.ListNode;

public class Demo234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        boolean result = true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转链表
        ListNode second = reverseList(slow.next);
        slow.next = null;


        ListNode cur1 = head, cur2 = second;
        while (cur2 != null) {
            if (cur1.val != cur2.val) {
                result = false;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //需要将链表还原
        second = reverseList(second);
        slow.next = second;

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
