package demo01_50;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Demo37_look
{

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur!=null || !stack.isEmpty())
        {
            while (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }

    /*
    递归,太简单了,一般都要求使用迭代
     */
    public List<Integer> inorderTraversal1(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode root, List<Integer> result)
    {
        if(root==null) return;
        recursive(root.left,result);
        result.add(root.val);
        recursive(root.right, result);
    }
}
