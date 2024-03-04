package hot;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = recursive(root, new StringBuilder());
        return sb.toString();
    }

    private StringBuilder recursive(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null ");
            return sb;
        }
        sb.append(root.val);
        sb.append(" ");
        recursive(root.left, sb);
        recursive(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(" ");
        List<String> list = new LinkedList<>(Arrays.asList(temp));
        return deRecursive(list);
    }

    private TreeNode deRecursive(List<String> list) {
        //最起码有个null
        TreeNode root;

        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        else {
            root = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            root.left = deRecursive(list);
            root.right = deRecursive(list);
        }

        return root;
    }
}
