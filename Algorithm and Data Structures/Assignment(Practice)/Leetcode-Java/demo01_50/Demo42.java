package demo01_50;

import utils.TreeNode;

public class Demo42
{
    private int result = 0;

    public int maxDepth(TreeNode root)
    {
        recursive(root, 0);
        return result;
    }

    private void recursive(TreeNode node, int height)
    {
        if(node==null)
        {
            result = Math.max(result, height);
            return;//FBI warning 注意,递归这里一定要返回
        }
        recursive(node.left,height+1);
        recursive(node.right,height+1);
    }
}
