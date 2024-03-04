package demo51_100;

import utils.ListNode;

public class Demo66
{
    /*
    快慢指针找中点
    后半链表反转变成-><-
    逐个对比
    反转回原数组
     */
    public boolean isPalindrome(ListNode head)
    {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow为中点,如果为奇数,就是正中,偶数,就是后面一个
        //反转链表 pre
        ListNode pre = reverse(slow);

        ListNode first = head, second = pre;
        while(second!=null)
        {
            if(first.val!=second.val)
            {
                reverse(pre);//反转回原链表
                /*
                能成功的关键在于
                例如:1,2,3,4,5,6
                前面的是1,2,3,4;而后面的是6,5,4,null再次反转后变成了4,5,6
                但是前面的还是指向了4,而4后面的执行正常
                 */
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(pre);//反转回原链表
        return true;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode temp = head,pre=null,cur=head;
        while(cur!=null)
        {
            cur = cur.next;
            temp.next = pre;
            pre = temp;
            temp = cur;
        }
        return pre;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        new Demo66().isPalindrome(head);
    }
}
