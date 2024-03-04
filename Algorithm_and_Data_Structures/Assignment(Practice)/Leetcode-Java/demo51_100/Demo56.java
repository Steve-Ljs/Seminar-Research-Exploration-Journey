package demo51_100;

import utils.ListNode;

public class Demo56
{
    /*
    如果有个链表走到尽头,那么就让他指向另一个链表开头
    要注意没有交集情况判断
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null) return null;//防止有某个链表本身就是null
        ListNode curA = headA, curB = headB;
        while (curA != curB)//正常情况相交与一个节点,异常情况走两次都到了null
        {

            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
