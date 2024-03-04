package niuke;

import utils.ListNode;

public class JZ36 {
    /*
    两条链表都走上，最后cur1，cur2要不相遇在前面，要不相遇在null
    例如1->2,3->4->5
    cur1:1->2->null->3->4->5->null
    cru2:3->4->5->null->1->2->null
    */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1, cur2 = pHead2;
        while(cur1 != cur2) {
            cur1 = cur1 == null ? pHead2 : cur1.next;
            cur2 = cur2 == null? pHead1 : cur2.next;
        }
        return cur1;
    }
}
