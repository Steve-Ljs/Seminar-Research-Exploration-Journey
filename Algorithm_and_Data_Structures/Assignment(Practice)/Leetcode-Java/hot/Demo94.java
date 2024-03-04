package hot;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Demo94
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty())
        {
            while(current!=null)
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        TreeNode temp = root.right;
        temp.left = new TreeNode(3);
        new Demo94().inorderTraversal(root);
    }

    public List<Integer> inorderTraversal1(TreeNode root)
    {
        List<Integer> result = new LinkedList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode node, List<Integer> result)
    {
        if(node==null)
        {
            return;
        }
        recursive(node.left,result);
        result.add(node.val);
        recursive(node.right,result);
    }
}
