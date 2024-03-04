package hot;

import utils.ListNode;

public class Demo19
{
    /*
    边界:如果head=null,返回null
    因为n保证是合理的,所以1<=n<=head.length
    如果n==head.length那么fast为null,此时是删除首元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head==null) return null;
        if(n<=0) throw new IllegalArgumentException();//必须>0

        ListNode fast=head, slow=head;
        for (int i = 0; i < n; i++)
        {
            if(fast==null) throw new IllegalArgumentException();
            fast = fast.next;
        }
        //如果fast==null,说明删除第一个元素
        if(fast==null)
        {
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }
        //快慢指针一起往前
        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow.next指向要删除的元素
        slow.next = slow.next.next;
        return head;
    }
}
