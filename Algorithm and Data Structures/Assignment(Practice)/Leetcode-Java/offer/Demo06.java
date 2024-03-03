package offer;

import utils.ListNode;

import java.util.*;

public class Demo06 {
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Deque<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return result;
        printListFromTailToHead(listNode.next);
        result.add(listNode.val);

        return result;
    }
}
