package offer;

import utils.ListNode;

public class Demo18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            if (cur.val == val) {
                if (pre == null) {
                    return cur.next;
                }
                else {
                    pre.next = cur.next;
                    cur.next = null;
                    return head;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
