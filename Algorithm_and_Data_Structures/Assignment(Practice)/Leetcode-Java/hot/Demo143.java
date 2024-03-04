package hot;

import utils.ListNode;

public class Demo143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        //变成两个链表 快慢指针找中点
        ListNode first = head, slow = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            slow = slow.next;
        }
        /*
            1,2,3,4 则mid=4
            1,2,3,4,5 则mid=4
            要合并,则保证上面的比下面的多2或1个节点
        */
        ListNode mid = slow.next;
        slow.next = null;
        //将第二个链表逆序
        ListNode cur = mid, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //两个链表合并
        ListNode cur1 = head, cur2 = pre, next1 = null, next2 = null;
        while (cur1 != null && cur2 != null) {
            next1 = cur1.next;
            next2 = cur2.next;

            cur1.next = cur2;
            cur2.next = next1;

            cur1 = next1;
            cur2 = next2;
        }
    }
}
