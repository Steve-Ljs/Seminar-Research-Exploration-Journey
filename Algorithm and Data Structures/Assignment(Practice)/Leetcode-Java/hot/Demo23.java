package hot;

import utils.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo23
{
    class Tuple
    {
        Integer key;
        Integer value;

        public Tuple(Integer key, Integer value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        ListNode pre = new ListNode(-1),cur=pre;
        //用优先队列存储每个链表最前面的值,以及他们对应是哪个链表
        Queue<Tuple> queue = new PriorityQueue<>((tuple1,tuple2)->(tuple1.key-tuple2.key));
        for (int i = 0; i < lists.length; i++)
        {
            //注意要非null
            if(lists[i]!=null)
            {
                queue.add(new Tuple(lists[i].val, i));
                lists[i] = lists[i].next;
            }
        }
        while(!queue.isEmpty())
        {
            Tuple tuple = queue.poll();//弹出最小的一个数

            //look,自己创建链表的问题l,不能用pre来算
            cur.next=new ListNode(tuple.key);
            cur = cur.next;

            //look,引用的问题,应该是让数组的引用向下一位
            if(lists[tuple.value]!=null)
            {
                queue.add(new Tuple(lists[tuple.value].val,tuple.value));//tuple.values标识是哪个链表
                lists[tuple.value] = lists[tuple.value].next;
            }
        }
        return pre.next;
    }
    public ListNode mergeKLists1(ListNode[] lists)
    {
        int n = lists.length;
        if (n == 0) return null;
        while (n > 1)
        {
            for (int i = 0; i < n / 2; i++)
            {
                lists[i] = mergeTwoLists(lists[i], lists[n - 1 - i]);
            }
            n = (n + 1) / 2;//考虑奇数有一个没参与合并,但是要参与下一次运算
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = null;

        if (l1.val < l2.val)
        {
            result = new ListNode(l1.val);
            result.next = mergeTwoLists(l1.next, l2);
        }
        else
        {
            result = new ListNode(l2.val);
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }
}
