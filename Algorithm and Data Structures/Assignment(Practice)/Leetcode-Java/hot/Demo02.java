package hot;

import utils.ListNode;

public class Demo02
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        //第一个元素只是为了方便编程
        //result代表结果链表的头部,current则构造该链表
        ListNode result = new ListNode(-1);
        ListNode current = result;

        int carryOver = 0;//进位标志
        //三者只要其中一个满足条件,就能计算下去
        while (l1 != null || l2 != null || carryOver != 0)
        {
            //需要判断l1,l2是否为null
            int value1 = 0, value2 = 0;
            if (l1 != null)
            {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                value2 = l2.val;
                l2 = l2.next;
            }

            int value = value1 + value2 + carryOver;
            //是否进位
            //顺序不能颠倒,否则value已经<10,carryOver一定为0
            carryOver = value / 10;
            value = value % 10;

            //构造结果链表
            current.next = new ListNode(value);
            current = current.next;
        }
        //链表第二个元素起才有实际的意义
        return result.next;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(7);
        new Demo02().addTwoNumbers(l1, l2);

    }

}
