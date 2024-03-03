package offer;

import utils.TreeNode;

public class Demo55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        return false;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
