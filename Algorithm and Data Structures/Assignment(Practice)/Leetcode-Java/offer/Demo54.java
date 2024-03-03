package offer;

import utils.TreeNode;

public class Demo54 {
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        int count = count(root.right);
        if (count >= k) return kthLargest(root.right, k);
        else if (count == k - 1) return root.val;
        else return kthLargest(root.left, k - count - 1);
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}
