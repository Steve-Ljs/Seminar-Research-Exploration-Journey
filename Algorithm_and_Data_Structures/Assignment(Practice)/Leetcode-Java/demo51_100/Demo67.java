package demo51_100;

import utils.TreeNode;

public class Demo67
{
    /*
    找到的话return不为null,所以可以判断left和right,如果某一边为null,说明不在那一边,那么直接返回
    另外一边即可,因为这个就是他们的根.如果都不为null,说明各在两边,则返回他们的父节点,即上一级的
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
