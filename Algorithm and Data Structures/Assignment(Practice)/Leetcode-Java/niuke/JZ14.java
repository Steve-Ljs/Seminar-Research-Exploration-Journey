package niuke;

import utils.ListNode;

public class JZ14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0) return null;
        ListNode fast = head, node = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast != null) {
            node = node.next;
            fast = fast.next;
        }
        return node;
    }
}
