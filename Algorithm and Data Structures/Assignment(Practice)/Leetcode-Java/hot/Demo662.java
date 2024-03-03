package hot;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MyTreeNode {
    TreeNode node;
    int index; //索引编号

    MyTreeNode (TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class Demo662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        Deque<MyTreeNode> queue = new LinkedList<>();
        //利用堆排序的定义找到对应的层级
        queue.offer(new MyTreeNode(root, 1));
        int sum = 0; //每层个数
        while (!queue.isEmpty()) {
            //一次处理一层
            sum = queue.size();
            //知道了该层最大index以及起点index
            result = Math.max(result, queue.getLast().index - queue.getFirst().index + 1);

            for (int i = 0; i< sum; i++) {
                MyTreeNode myNode = queue.poll();
                if (myNode.node.left != null) {
                    queue.add(new MyTreeNode(myNode.node.left, myNode.index * 2));
                }
                if (myNode.node.right != null) {
                    queue.add(new MyTreeNode(myNode.node.right, myNode.index * 2 + 1));
                }
            }
        }
        return result;
    }

}
