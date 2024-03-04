package demo01_50;

import utils.ListNode;

public class Demo10
{
    /*
    思路是让fast先走n次,然后slow,fast一起走,当fast.next==null时,slow.next指向要删除的元素
    边界:如果head=null,返回null
    因为n保证是合理的,所以1<=n<=head.length
    如果n==head.length那么fast为null,此时是删除首元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head==null) return null;
        if(n<=0) return head;
        ListNode fast = head, slow = head;
        //因为保证n合理,所以fast==null,意味着n=head.length,如果大于,也是删除了首元素
        for (int i = 0; i < n; i++)
        {
            fast = fast.next;//刚开始的head保证不为null
            if(fast==null) return head.next;
        }
        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
