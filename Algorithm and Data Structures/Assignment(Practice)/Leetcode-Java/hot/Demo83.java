package hot;

import utils.ListNode;

public class Demo83 {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode next = head.next;
        while (next != null && next.val == head.val) {
            next = next.next;
        }
        head.next = deleteDuplicates(next);
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return head;
    }
}
