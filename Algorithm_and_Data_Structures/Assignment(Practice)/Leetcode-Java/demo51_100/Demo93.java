package demo51_100;

import utils.TreeNode;

public class Demo93
{
    public TreeNode convertBST(TreeNode root)
    {
        if(root==null) return null;
        convertBST(root.right);
        root.val += result;
        result = root.val;
        convertBST(root.left);
        return root;
    }
    private int result = 0;
}
