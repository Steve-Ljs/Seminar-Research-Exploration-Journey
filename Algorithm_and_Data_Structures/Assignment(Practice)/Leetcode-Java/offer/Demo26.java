package offer;

import utils.TreeNode;

public class Demo26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //以该节点为根节点的遍历,与去左右找的遍历
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        //把B匹配完毕没出错,则任务完成
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
