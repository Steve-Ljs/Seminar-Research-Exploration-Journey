package hot;

import utils.ListNode;

public class Demo92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null, cur = head, next = null;
        //标记穿针引线的节点
        ListNode node1, node2, node3, node4;
        //先找到要反转位置
        for (int i = 0; i < m - 1; i++) {
            //说明m不合法
            if (cur == null) {
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        //此时cur指向要逆转的node
        node1 = pre;
        node2 = cur;

        //逆转
        for (int i = 0; i < n - m + 1; i++) {
            //说明n不合法
            if (cur == null) {
                return head;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        node3 = pre;
        node4 = cur;

        //穿针引线
        //得先看看是否为null
        if (node1 != null) {
            node1.next = node3;
        }
        else {
            //画图,即前半部分没有了,只从反转的开始
            head = node3;
        }
        if (node2 != null) {
            node2.next = node4;
        }
        return head;
    }
}
