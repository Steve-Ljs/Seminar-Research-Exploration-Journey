package niuke;

import utils.TreeNode;

public class JZ26 {

    //记录当前链表的末尾节点
    TreeNode tail;
    /*
    处理结束并返回最左边的节点 并且会把tail给正确指向
    */
    public TreeNode Convert1(TreeNode root) {
        if (root == null) return null;

        //处理左子树
        TreeNode head = Convert1(root.left);

        //左子树为空，那根节点就是最左节点
        if (head == null)  head = root;


        //因为Convert(root.left)执行完之后，左子树的最后一个节点会记录到lastNode上
        if (tail != null) {
            root.left = tail;
            tail.right = root;
        }

        tail = root;


        Convert1(root.right);

        return head;
    }


   /* 对递归直观的理解：
    整个函数的作用是
    把二叉搜索树变成有序双向链表，并返回最左边的节点
    所以先处理右子树，让右子树排成有序链表并且返回第一个节点。
    随后与根节点形成链接
    再处理左子树，让左子树排成有序链表并且返回第一个节点。
    随后再找到左子树有序链表的最后一个节点，与根节点形成链接
    最后返回左子树第一个节点

    处理结束并返回最左边的节点
    */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        //先处理好右子树
        TreeNode rightHead = Convert(pRootOfTree.right);
        pRootOfTree.right = rightHead;
        if (rightHead != null) {
            rightHead.left = pRootOfTree;
        }

        //再处理左子树
        TreeNode leftHead = Convert(pRootOfTree.left);

        //左子树为空，那直接返回根节点
        if (leftHead == null) {
            return pRootOfTree;
        } else {
            //找到左子树的最后一个节点
            TreeNode leftTail = leftHead;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;

            return leftHead;
        }

    }
}
