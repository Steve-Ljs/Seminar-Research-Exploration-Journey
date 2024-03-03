package demo01_50;

import utils.TreeNode;

public class Demo44_look
{
    public void flatten(TreeNode root)
    {
        while(root!=null)
        {
            if(root.left!=null)
            {
                //找到左子树最右节点,并且将root右子树放到他后面
                TreeNode temp = root.left;
                while(temp.right!=null) temp = temp.right;
                temp.right = root.right;

                //将左子树变为右子树
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

}
