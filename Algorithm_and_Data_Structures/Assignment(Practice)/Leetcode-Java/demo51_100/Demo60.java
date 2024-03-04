package demo51_100;

import utils.ListNode;

public class Demo60
{
    public ListNode reverseList(ListNode head)
    {
        ListNode pre = null, temp = head, cur = head;
        while(cur!=null)
        {
            cur = cur.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
        }
        return pre;
    }
}
