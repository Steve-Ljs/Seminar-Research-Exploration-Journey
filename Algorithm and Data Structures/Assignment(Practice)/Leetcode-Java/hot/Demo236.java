package hot;

import utils.TreeNode;

public class Demo236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果p,q存在根中,则不用继续寻找了
        if(root==null || root==p || root==q) return root;
        //分别向左右递归寻找p,q的位置
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //因为题设p,q必然在树中,只有三种情况:p,q在左边,右边,各在一边
        //哪边为null则说明p或q不在那边
        return left==null? right:right==null?left:root;
    }
}
