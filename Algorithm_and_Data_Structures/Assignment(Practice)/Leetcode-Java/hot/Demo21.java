package hot;

import utils.ListNode;

public class Demo21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = null;

        if (l1.val < l2.val) {
            result = new ListNode(l1.val);
            result.next = mergeTwoLists(l1.next, l2);
        }
        else {
            result = new ListNode(l2.val);
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            }
            else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        }
        else {
            cur.next = l1;
        }
        return head.next;
    }
}
