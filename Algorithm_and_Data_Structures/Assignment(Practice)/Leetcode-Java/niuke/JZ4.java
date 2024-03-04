package niuke;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class JZ4 {
    /*
    把in放入map中，方便pre中根节点大小到in的索引的映射，map:(节点val,索引位置)
    用递归的方法，找到左子树，右子树对应的pre,in数组的索引位置
    */
    private Map<Integer, Integer> map;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return dfs(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode dfs(int[] pre, int preLo, int preHi, int[] in, int inLo, int inHi) {
        if (preHi < preLo) return null;

        int rootVal = pre[preLo];
        TreeNode root = new TreeNode(rootVal);

        //找到in中rootVal的索引位置
        int inRootIndex = map.get(rootVal);

        root.left = dfs(pre, preLo + 1, preLo + inRootIndex - inLo, in, inLo, inRootIndex - 1);
        root.right = dfs(pre, preLo + inRootIndex - inLo + 1, preHi, in, inRootIndex + 1, inHi);
        return root;
    }
}
