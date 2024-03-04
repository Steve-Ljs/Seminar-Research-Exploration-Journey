package demo51_100;

import utils.TreeNode;

public class Demo65
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
