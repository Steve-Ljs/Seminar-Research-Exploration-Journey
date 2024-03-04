package niuke;

import utils.ListNode;

public class JZ55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
