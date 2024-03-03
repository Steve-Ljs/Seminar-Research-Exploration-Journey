package hot;

import utils.ListNode;

public class Demo82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (next.val != head.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while (next != null && head.val == next.val) {
            next = next.next;
        }
        return deleteDuplicates(next);
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head, pre = preHead;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                return preHead.next;
            }
            if (next.val != cur.val) {
                pre = cur;
                cur = next;
                continue;
            }
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            pre.next = next;
            cur = next;
        }
        return preHead.next;
    }

}
