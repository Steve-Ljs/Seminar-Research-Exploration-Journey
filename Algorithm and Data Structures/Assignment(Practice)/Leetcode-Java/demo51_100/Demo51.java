package demo51_100;

import utils.ListNode;

public class Demo51
{
    //要求刚刚进入的节点
    public ListNode detectCycle(ListNode head)
    {
        ListNode fast = head, slow = head;
        while(true)
        {
            if(fast==null || fast.next==null) return null;//说明没有循环
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        fast = head;//必定有循环
        while(fast!=slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
