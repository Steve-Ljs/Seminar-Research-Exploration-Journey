package demo51_100;

import utils.TreeNode;

public class Demo81
{
    //result[0]代表该节点不偷得的最大值,result[1]代表该节点偷所能得的最大值
    public int rob(TreeNode root)
    {
        int[] result = recursive(root);
        return Math.max(result[0], result[1]);
    }

    private int[] recursive(TreeNode root)
    {
        if(root==null) return new int[2];//为的是其他的也能使用里面的0
        int[] result = new int[2];

        int[] left = recursive(root.left);
        int[] right = recursive(root.right);

        /*
        这样就包括了4种情况:
            1.爷爷偷,儿子不偷
            2.爷爷不偷,左右儿子都偷
            3.爷爷不偷左儿子偷
            4.爷爷不偷右儿子偷
         1在result[1]中,2,3,4在result[0]中,且result[0]选取了2,3,4情况的最大值
         */
        result[1] = left[0] + right[0] + root.val;
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }

    //暴力递归,效率低,还有点晕
    /*public int rob(TreeNode root)
    {
        if(root==null) return 0;

        int money = root.val;
        if(root.left!=null)
        {
            money += rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null)
        {
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }*/

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(15);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);

        int rob = new Demo81().rob(root);
        System.out.println(rob);
    }
}
