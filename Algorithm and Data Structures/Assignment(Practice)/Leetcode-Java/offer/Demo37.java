package offer;

import utils.TreeNode;

import java.util.Arrays;

public class Demo37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfs(root, sb);
        return sb.toString();
    }

    private void serializeDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serializeDfs(root.left, sb);
        serializeDfs(root.right, sb);
    }

    private int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(" ");
        //从数组索引0开始(根节点)
        return deserializeDfs(strings);
    }

    private TreeNode deserializeDfs(String[] strings) {
        TreeNode root;

        if (strings[index].equals("n")) {
            index++;
            return null;
        }
        else {
            root = new TreeNode(Integer.parseInt(strings[index]));
            index++;
            root.left = deserializeDfs(strings);
            root.right = deserializeDfs(strings);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = new Demo37().serialize(root);
        System.out.println(serialize);


        String[] s = "1 2 3 null ".split(" ");
        System.out.println(s.length);
        System.out.println("x"+s[0]+"x");
        System.out.println("x"+s[1]+"x");
        System.out.println("x"+s[2]+"x");
        System.out.println("x"+s[3]+"x");
    }
}
