package demo01_50;

import utils.ListNode;

/*
当没有思路或者不好分析时,不妨用比较多的if分详细情况讨论,之后再简化
 */
/*
class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = recursive(l1, l2,0);
        return head;
    }

    // int carryOver进位标志
    private ListNode recursive(ListNode l1, ListNode l2,int carryOver)
    {
        if(l1==null && l2==null && carryOver==0) return null;
        else if(l1==null && l2==null && carryOver==1) return new ListNode(1);
        else if(l1==null)
        {
            int add = l2.val + carryOver;
            if(add>=10)
            {
                carryOver = 1;
                add -= 10;
            }
            else
            {
                carryOver = 0;
            }
            ListNode node = new ListNode(add);
            node.next = recursive(null, l2.next, carryOver);
            return node;
        }
        else if(l2==null)
        {
            int add = l1.val + carryOver;
            if(add>=10)
            {
                carryOver = 1;
                add -= 10;
            }
            else
            {
                carryOver = 0;
            }
            ListNode node = new ListNode(add);
            node.next = recursive(l1.next, null, carryOver);
            return node;
        }
        int add = l1.val + l2.val + carryOver;
        if(add>=10)
        {
            carryOver = 1;
            add -= 10;
        }
        else
        {
            carryOver = 0;
        }
        ListNode node = new ListNode(add);
        node.next = recursive(l1.next, l2.next, carryOver);
        return node;
    }
}
 */

public class Demo02
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = recursive(l1, l2,0);
        return head;
    }

    // int carryOver进位标志
    private ListNode recursive(ListNode l1, ListNode l2,int carryOver)
    {
        if(l1==null && l2==null && carryOver==0) return null;
        else if(l1==null && l2==null && carryOver==1) return new ListNode(1);
        int add = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carryOver;
        carryOver = 0;//本次运算产生的进位
        if(add>=10)
        {
            carryOver = 1;
            add -= 10;
        }
        ListNode node = new ListNode(add);
        node.next = recursive(l1==null?null:l1.next, l2==null?null:l2.next, carryOver);
        return node;
    }
}
