package offer;

public class Demo36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head, tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        dfs(root);

        tail.right = head;
        head.left = tail;

        return head;

    }

    public void dfs(Node root) {
        if (root == null) return;

        dfs(root.left);

        //想象左边已经是一条双向链表了
        //但是要注意初始条件
        if (head == null) head = root;
        else tail.right = root;

        root.left = tail;

        tail = root;//tail的范围扩展到了root

        dfs(root.right);//全部迭代完成后，tail指向双向链表中的尾节点
    }
}
