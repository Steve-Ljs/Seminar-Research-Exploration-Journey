package offer;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Demo07 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //特殊情况
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length) {
            return null;
        }
        //存储in数组的value,index,以便快速定位到root的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree(pre, in, map, 0, pre.length - 1, 0, in.length - 1);

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, Map<Integer, Integer> map, int preLo, int preHi, int inLo, int inHi) {
        if (preLo > preHi) return null;

        int rootValue = pre[preLo];
        //构造root,并且分割左右子树对应的数组继续递归构造
        TreeNode root = new TreeNode(rootValue);
        //从中序数组中找到左子树的大小
        int rootIndex = map.get(rootValue);

        //递归的构造
        root.left = reConstructBinaryTree(pre, in, map, preLo + 1, preLo + rootIndex - inLo, inLo, rootIndex - 1);
        root.right = reConstructBinaryTree(pre, in, map, preLo + rootIndex - inLo + 1, preHi, rootIndex + 1, inHi);

        return root;
    }
}
