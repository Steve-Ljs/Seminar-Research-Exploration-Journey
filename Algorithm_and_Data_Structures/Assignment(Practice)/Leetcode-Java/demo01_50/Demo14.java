package demo01_50;

import utils.ListNode;

public class Demo14
{
    /*
    归并的想法,两两合并,不断合并到只剩下一个
     */
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists==null || lists.length==0) return null;
        int n = lists.length;
        while(n>1)
        {
            for (int i = 0; i < n / 2; i++)
            {
                lists[i] = mergeTwoLists(lists[i], lists[n - i - 1]);
            }
            n = (n + 1) / 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode head;
        if(list1.val<list2.val)
        {
            head = new ListNode(list1.val);
            head.next = mergeTwoLists(list1.next, list2);
        }
        else
        {
            head = new ListNode(list2.val);
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }
}
