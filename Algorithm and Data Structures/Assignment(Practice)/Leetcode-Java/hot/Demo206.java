package hot;

import utils.ListNode;

public class Demo206
{
    public ListNode reverseList(ListNode head)
    {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) return head;

        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


    public ListNode reverseList1(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next, next = head.next.next;
        head.next = null;
        while (cur != null)
        {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) next = next.next;
        }
        return pre;
    }
}
