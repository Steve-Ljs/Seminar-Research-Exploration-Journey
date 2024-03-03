package hot;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Demo105
{
    /**
     * look 用map存储加快速度
    树中没有重复元素
    用map存储inorder数组的值和对应索引
     方便找到根节点位置
     */
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        for (int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi)
    {
        if (preLo > preHi || inLo > inHi)
        {
            return null;
        }
        //找到根节点在中序遍历的索引位置
        int inIndex = map.get(preorder[preLo]);
        //look,i在经过几次之后,只是对应了inorder的i,但是对于preorder,应该只是一个偏移量
        //inIndex - inLo代表左子树的个数,preIndex则是前序遍历左子树的最后一个元素
        int preIndex = preLo + inIndex - inLo;
        TreeNode root = new TreeNode(preorder[preLo]);
        root.left = buildTree(preorder, preLo + 1, preIndex, inorder, inLo, inIndex - 1);
        root.right = buildTree(preorder, preIndex + 1, preHi, inorder, inIndex + 1, inHi);
        return root;
    }
}
