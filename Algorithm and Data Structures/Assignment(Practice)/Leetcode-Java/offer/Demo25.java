package offer;

import utils.ListNode;

public class Demo25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            ListNode node = new ListNode(l1.val);
            node.next = mergeTwoLists(l1.next, l2);
            return node;
        }
        else {
            ListNode node = new ListNode(l2.val);
            node.next = mergeTwoLists(l1, l2.next);
            return node;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1), cur = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode temp = new ListNode(l1.val);
                l1 = l1.next;
                cur.next = temp;
                cur = cur.next;
            }
            else {
                ListNode temp = new ListNode(l2.val);
                l2 = l2.next;
                cur.next = temp;
                cur = cur.next;
            }   
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
