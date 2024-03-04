package hot;

import utils.ListNode;

public class Demo160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            tempA = (tempA == null ? headB : tempA.next);
            tempB = (tempB == null ? headA : tempB.next);
        }
        return tempA;
    }


}
