package offer;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    temp.add(node.val);
                }
                else {
                    temp.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            isLeft = !isLeft;
            result.add(temp);
        }
        return result;
    }
}
