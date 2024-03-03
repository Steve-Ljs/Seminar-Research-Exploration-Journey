package niuke;

import utils.ListNode;

public class JZ56 {
    /*
    用虚拟头节点更加简单..

   找到重复元素时往下继续找，找到第一个不重复的，指针赋值

   注意头指针就重复的情况
   */
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode pre = null, cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                return pHead;
            }
            else if (next.val != cur.val) {
                pre = cur;
                cur = next;
            }
            else {
                //进入该分支，说明有重复
                while (next != null && next.val == cur.val) next = next.next;

                if (pre == null) {
                    //说明头节点出现重复
                    pHead = next;
                    cur = pHead;
                }
                else {
                    pre.next = next;
                    cur = next;
                }
            }
        }
        return pHead;
    }
}
