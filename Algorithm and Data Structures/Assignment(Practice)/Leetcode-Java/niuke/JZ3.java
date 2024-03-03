package niuke;

import utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class JZ3 {
    private ArrayList<Integer> result = new ArrayList<>();

    /*
    使用递归实现
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return result;
        printListFromTailToHead(listNode.next);
        result.add(listNode.val);
        return result;
    }

    /*
    使用栈来实现
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
