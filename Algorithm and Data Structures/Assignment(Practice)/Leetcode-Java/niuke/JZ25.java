package niuke;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class JZ25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur1 = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (cur1 != null) {
            RandomListNode temp = new RandomListNode(cur1.label);
            RandomListNode nextNode = cur1.next;
            cur1.next = temp;
            temp.next = nextNode;
            cur1 = nextNode;
        }

        cur1 = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (cur1 != null) {
            if (cur1.random != null) {
                cur1.next.random = cur1.random.next;
            }
            cur1 = cur1.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        cur1 = pHead;
        RandomListNode head2 = pHead.next;
        while (cur1 != null) {
            RandomListNode cur2 = cur1.next;
            cur1.next = cur2.next;
            cur2.next = cur2.next == null ? null : cur2.next.next;
            cur1 = cur1.next;
        }

        return head2;
    }
}
