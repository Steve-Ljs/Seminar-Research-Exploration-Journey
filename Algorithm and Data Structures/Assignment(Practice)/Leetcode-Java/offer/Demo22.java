package offer;

import utils.ListNode;

public class Demo22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head, cur = head;

        if (k <= 0) return null;
        for (int i = 0; i < k; i++) {
            if (first != null) {
                first = first.next;
            }
            else {
                return null;
            }
        }

        while (first != null) {
            first = first.next;
            cur = cur.next;
        }
        return cur;
    }
}
