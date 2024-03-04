package march;


import utils.ListNode;

public class Demo2 {
    /*
    链表头相加，考虑进位
    一直加到其中一个链表该位为空，并且进位为0
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur1 = l1, cur2 = l2;
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        int carry = 0;
        //如果还有进位，或者两链表都不为空则继续
        while (carry != 0 || (cur1 != null && cur2 != null)) {
            int val = carry;
            if (cur1 != null) {
                val += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                val += cur2.val;
                cur2 = cur2.next;
            }

            if (val / 10 == 0) {
                carry = 0;
            }
            else {
                carry = 1;
                val %= 10;
            }

            cur.next = new ListNode(val);
            cur = cur.next;
        }

        //look 因为其中一个链表为null，但是另外一个链表的值还需要继续计算
        if (cur1 != null) cur.next = cur1;
        if (cur2 != null) cur.next = cur2;

        return result.next;
    }
}
