package hot;

import utils.TreeNode;

import java.util.Stack;

public class Demo114
{

    /**
     *
     * 该做法是不断将右子树放在左子树的最后一个节点上,再将左子树变为右子树
     * 更加直观,更加符合中左右的形式
     */
    public void flatten1(TreeNode root)
    {
        while(root!=null)
        {
            //没有左子树,则直接到下一个右子树上,不需要继续考虑
            if(root.left!=null)
            {
                //找到左子树最右节点
                TreeNode temp = root.left;
                while(temp.right!=null)
                {
                    temp = temp.right;
                }

                //将右子树放在左子树的最后一个节点上
                temp.right = root.right;

                //将左子树变为右子树
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    /**
     * 该方法是先把左子树放当前节点右边,当到最后一个左节点时,再放入右节点
     * 速度比较慢
     */
    public void flatten(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null)
        {
            //保存当前节点的右节点
            if(root.right!=null)
            {
                stack.push(root.right);
            }

            //将当前节点的左子树转移到右子树
            root.right = root.left;
            root.left = null;

            //说明往左遍历结束了
            if(root.right==null)
            {
                if(!stack.isEmpty())
                {
                    root.right = stack.pop();
                }
                else
                {
                    //说明左右子树都没了
                    return;
                }
            }
            root = root.right;
        }
    }
}
