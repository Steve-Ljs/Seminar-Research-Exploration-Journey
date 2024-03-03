package demo01_50;

import utils.TreeNode;

import java.util.Stack;

public class Demo39
{
    /*
    中序遍历,如果后面的节点小于等于前面的节点,就不是二叉搜索树
    注意的是,如果最左边的正好是Integer.MIN_VALUE
    或者有两个Integer.MIN_VALUE,isFirst
     */
    public boolean isValidBST(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        int pre=0;
        boolean isFirst = true;
        TreeNode temp = root;
        while(temp!=null || !stack.isEmpty())
        {
            while(temp!=null)
            {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();

            if(isFirst) isFirst = false;//FBI warning 为的是最左边那个逻辑上是正确的
            else if(temp.val<=pre)return false;

            pre = temp.val;
            temp = temp.right;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MAX_VALUE);
    }
}
