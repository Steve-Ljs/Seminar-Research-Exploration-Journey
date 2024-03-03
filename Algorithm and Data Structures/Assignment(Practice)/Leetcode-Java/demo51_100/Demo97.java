package demo51_100;


import utils.TreeNode;

public class Demo97
{
    public static void main(String[] args)
    {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2)
    {
        if (t1 == null && t2 == null)
        {
            return null;
        }
        else if (t1 != null && t2 != null)
        {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
        else
        {
            return t1 == null ? t2 : t1;
        }
    }
}