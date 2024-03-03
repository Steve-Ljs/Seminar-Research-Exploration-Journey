package hot;

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

public class Demo138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //再每个节点旁边复制出一个节点
        Node cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur = cur.next;
            cur.next = next;
            cur = next;
        }
        //模拟原本的拷贝一份指针
        Node first = head, second = head.next;
        while (first != null) {
            if (first.random != null) {
                second.random = first.random.next;
            }
            first = first.next.next;
            if (second.next != null) {
                second = second.next.next;
            }

        }
        //断开和原来的链接
        Node newHead = head.next;
        first = head;
        second = newHead;
        while (first != null) {
            first.next = second.next;
            first = second.next;

            if (first != null) {
                second.next = first.next;
                second = first.next;
            }

        }
        return newHead;
    }
}
