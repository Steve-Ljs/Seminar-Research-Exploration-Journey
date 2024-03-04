package demo51_100;

import utils.ListNode;

public class Demo53
{
    /*
    归并法:先切分为1个,再不断22合并
     */
    public ListNode sortList(ListNode head)
    {
       if(head==null || head.next==null) return head;//只有一个元素或者为空

        ListNode slow = head, fast = head;//slow指向中点链表
        while(true)
        {
            fast = fast.next.next;//刚刚进来时,有head判断,是安全的
            if(fast==null || fast.next==null)//为了断开中点前一个节点与中点之间的连接
            {
                ListNode temp = slow;
                slow = slow.next;
                temp.next = null;
                break;
            }
            slow = slow.next;
        }
        ListNode head1=sortList(head);
        ListNode head2=sortList(slow);
        return merge(head1, head2);
    }
    public ListNode merge(ListNode head1, ListNode head2)//合并两个有序链表
    {
        if(head1==null) return head2;
        if(head2==null) return head1;
        int val;
        if(head1.val>head2.val)
        {
            val = head2.val;
            head2 = head2.next;
        }
        else
        {
            val = head1.val;
            head1 = head1.next;
        }
        ListNode head = new ListNode(val);
        head.next = merge(head1, head2);
        return head;
    }
}
