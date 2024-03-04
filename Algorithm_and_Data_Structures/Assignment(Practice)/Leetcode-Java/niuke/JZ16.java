package niuke;

import utils.TreeNode;

public class JZ16 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //空树不是任何的子结构
        if (root1 == null || root2 == null) return false;
        return check(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean check(TreeNode root1, TreeNode root2) {
        //只要存在其中一段root1匹配root2即可，所以只要匹配完root2就行,root1可以不为null
        if (root2 == null) return true;
        if (root1 == null || root1.val != root2.val) return false;
        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }
}
