package demo01_50;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Demo41
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new LinkedList<>();
        recursive(root, result, 0);
        return result;
    }

    private void recursive(TreeNode node, List<List<Integer>> result, int height)
    {
        if(node==null) return;
        if(height>=result.size()) result.add(new LinkedList<>());
        result.get(height).add(node.val);
        recursive(node.left,result,height+1);
        recursive(node.right,result,height+1);
    }
}
