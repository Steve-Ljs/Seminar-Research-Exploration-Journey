package hot;

import utils.TreeNode;

import javax.management.MXBean;
import java.util.Stack;

public class Demo98
{
    public boolean isValidBST(TreeNode root)
    {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp = root;
        boolean isFirst = true;
        int pre=0;
        while(temp!=null || !stack.isEmpty())
        {
            while(temp!=null)
            {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if(isFirst)
            {
                pre = temp.val;
                isFirst = false;
            }
            else if(temp.val<=pre)
            {
                return false;
            }
            pre = temp.val;
            temp = temp.right;
        }
        return true;
    }

}
