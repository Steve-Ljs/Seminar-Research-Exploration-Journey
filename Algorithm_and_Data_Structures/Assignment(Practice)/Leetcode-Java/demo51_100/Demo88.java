package demo51_100;


import utils.TreeNode;

public class Demo88
{
    //数组存储每一层节点的值,当然左右节点在同一层,例如用完了左节点就把右节点覆盖上去
    public int pathSum(TreeNode root, int sum)
    {
        return recursive(root, sum,new int[1000],0);
    }

    private int recursive(TreeNode node, int sum,int [] nodesValue,int height)
    {
        if(node==null) return 0;
        nodesValue[height] = node.val;//先给这一层赋值
        
        int nodePath = 0;//寻找从当前层到根节点是否存在和为sum的路径
        int nodeSum = 0;
        for (int i = height; i >=0; --i)
        {
            nodeSum += nodesValue[i];
            if(nodeSum==sum) ++nodePath;
        }

        return nodePath + recursive(node.left,sum,nodesValue,height+1)
                + recursive(node.right,sum,nodesValue,height+1);
    }

}
