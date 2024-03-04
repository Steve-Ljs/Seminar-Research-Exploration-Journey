package hot;

import utils.ListNode;

public class Demo148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(second);
        return merge(l1, l2);
    }

    //合并俩个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1), cur = preHead, temp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        else {
            cur.next = l1;
        }
        return preHead.next;
    }
}
