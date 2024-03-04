package offer;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
