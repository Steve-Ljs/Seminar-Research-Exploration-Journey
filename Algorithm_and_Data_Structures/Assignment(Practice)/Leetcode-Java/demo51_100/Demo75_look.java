package demo51_100;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//先序遍历
public class Demo75_look {
    public String serialize(TreeNode root) {
        StringBuilder result = recursive(root, new StringBuilder());
        return result.toString();
    }

    private StringBuilder recursive(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null ");
            return stringBuilder;
        }
        stringBuilder.append(root.val);
        stringBuilder.append(" ");
        recursive(root.left, stringBuilder);
        recursive(root.right, stringBuilder);
        return stringBuilder;
    }

    public TreeNode deserialize(String data) {
        String[] temp = data.split(" ");
        List<String> list = new LinkedList<>(Arrays.asList(temp));
        return recursive1(list);
    }

    private TreeNode recursive1(List<String> list) {
        //不管如何,list起码有一个null元素
        TreeNode root;

        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        else {
            root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = recursive1(list);
            root.right = recursive1(list);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(new Demo75_look().serialize(root));
    }
}
