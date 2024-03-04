package demo51_100;

import utils.TreeNode;

public class Demo94
{
    public int diameterOfBinaryTree(TreeNode root)
    {
        recursive(root);
        return result;
    }

    private int recursive(TreeNode root)
    {
        if(root==null) return 0;
        int leftValue = recursive(root.left);
        int rightValue = recursive(root.right);
        result=Math.max(result,leftValue + rightValue);
        return Math.max(leftValue+1, rightValue+1);
    }

    private int result = 0;

}
