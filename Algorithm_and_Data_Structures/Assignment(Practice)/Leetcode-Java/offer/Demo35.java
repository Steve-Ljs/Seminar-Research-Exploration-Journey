package offer;

public class Demo35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //首先在下一位置复制一块
        //更改复杂指针
        //拆分两个链表出来
        Node cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            Node temp = new Node(cur.val);
            cur.next = temp;
            temp.next = next;
            cur = next;
        }

        Node cur1 = head, cur2 = head.next;
        while (cur1 != null) {
            if (cur1.random != null) {
                cur2.random = cur1.random.next;
            }
            cur1 = cur1.next.next;
            if (cur2.next != null) cur2 = cur2.next.next;
        }

        cur1 = head;
        cur2 = head.next;
        Node head2 = cur2;
        while (cur1 != null) {
            Node next1 = cur1.next.next;
            Node next2 = null;

            if (cur2.next != null) {
                //说明没有到最后一个
                next2 = cur2.next.next;
            }

            cur1.next = next1;
            cur2.next = next2;
            cur1 = next1;
            cur2 = next2;
        }
        return head2;
    }
}
