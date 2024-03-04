package demo01_50;

import utils.TreeNode;

public class Demo46_look
{
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        recursive(root);
        return result;
    }

    private int recursive(TreeNode root)
    {
        if(root==null) return 0;

        //如果左子树节点为负数,不介意抛弃他
        int leftValue = Math.max(recursive(root.left),0);
        int rightValue = Math.max(recursive(root.right),0);
        int sum = leftValue + rightValue + root.val;

        result = Math.max(result, sum);//根节点的不一定是最大的,所以要深入每个子节点寻找

        //传给上级时,只能给一条边上的,因为上级还要权衡他自己的另外一边
        return root.val + Math.max(leftValue, rightValue);
    }
}
