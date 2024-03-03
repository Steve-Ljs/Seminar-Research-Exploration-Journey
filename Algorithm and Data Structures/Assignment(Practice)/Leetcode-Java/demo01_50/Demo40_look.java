package demo01_50;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Demo40_look
{
    //迭代
    public boolean isSymmetric(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            if(temp1==null && temp2==null) continue;//FBI warning这里和递归不一样
            if(temp1==null || temp2==null) return false;
            if(temp1.val!=temp2.val) return false;
            queue.add(temp1.left);
            queue.add(temp2.right);
            queue.add(temp1.right);
            queue.add(temp2.left);
        }
        return true;
    }

    //递归
    public boolean isSymmetric1(TreeNode root)
    {
        return recursive(root, root);
    }

    private boolean recursive(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return left.val == right.val && recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}
