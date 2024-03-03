package hot;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Demo102
{
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root)
    {
        recursive(root, 0);
        return result;
    }

    private void recursive(TreeNode node, int height)
    {
        if(node==null)
        {
            return;
        }
        //最多就是等于,不会大于,因为每层不满足都会构建
        if(height==result.size())
        {
            result.add(new LinkedList<>());
        }
        result.get(height).add(node.val);

        recursive(node.left,height+1);
        recursive(node.right,height+1);
    }
}
