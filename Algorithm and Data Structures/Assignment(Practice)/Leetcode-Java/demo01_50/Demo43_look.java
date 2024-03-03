package demo01_50;

import utils.TreeNode;

import java.util.Arrays;

public class Demo43_look
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++)
        {
            //在前序中是根节点,所以又去中序找对应元素,以此分割左右子树
            //因为是递归,所以根节点都是preorder[0]
            if(preorder[0]==inorder[i])
            {
                /*
                前序切分为[1,i],[i+1,N-1]
                中序切分为[0,i-1],[i+1,N-1]
                原因是:preorder[0]为根节点,在中序找到i时,必然左边的都是左子树了,而前序中,中左右,
                所以到i处,正好是中左,而中序正好是左中
                 */
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i+1, preorder.length);
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i+1, inorder.length);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);

                break;
            }
        }
        return root;
    }
}
