package hot;

import utils.ListNode;

public class Demo86 {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode lessHead = new ListNode(-1);
        ListNode betterHead = new ListNode(-1);
        ListNode lessCur = lessHead, betterCur = betterHead;
        while (cur != null) {
            if (cur.val < x) {
                lessCur.next = cur;
                lessCur = lessCur.next;
            }
            else {
                betterCur.next = cur;
                betterCur = betterCur.next;
            }
            cur = cur.next;
        }
        //构成一条链表
        lessCur.next = betterHead.next;
        //防止循环
        betterCur.next = null;
        return lessHead.next;
    }
}
