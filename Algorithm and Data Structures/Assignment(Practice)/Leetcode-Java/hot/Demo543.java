package hot;

import utils.TreeNode;

public class Demo543 {
    private int result = 0; //全局的最大路径长度

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftValue = dfs(root.left), rightValue = dfs(root.right);
        result = Math.max(result, leftValue + rightValue);
        return Math.max(leftValue, rightValue) + 1;
    }
}
