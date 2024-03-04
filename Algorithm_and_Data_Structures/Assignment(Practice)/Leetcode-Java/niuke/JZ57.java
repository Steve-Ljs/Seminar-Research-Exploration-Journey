package niuke;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class JZ57 {
    /*
    中序遍历：左中右
    给定一个节点，找他下一个节点，既然该节点已经遍历过了，只能找他的右子树
    如果右子树为空，去到他的父节点
        如果该节点是父节点的左节点，则找父节点右子树的最小值
        如果该节点是父节点的右节点，则继续找父节点的父节点
    */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        TreeLinkNode right = dfs(pNode.right);
        if (right != null) return right;

        TreeLinkNode fatherNode = pNode.next;
        while (fatherNode != null) {
            if (fatherNode.left == pNode) {
                return fatherNode;
            }
            pNode = fatherNode;
            fatherNode = pNode.next;
        }

        return null;
    }

    //找中序遍历的最小值
    private TreeLinkNode dfs(TreeLinkNode root) {
        if (root == null) return null;
        TreeLinkNode left = dfs(root.left);
        if (left != null) return left;
        return root;
    }
}
