package offer;

import utils.TreeNode;

public class JZ61 {
    String Serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeDfs(root, result);
        return result.toString();
    }

    private void serializeDfs(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("null ");
            return;
        }

        result.append(root.val);
        result.append(" ");
        serializeDfs(root.left, result);
        serializeDfs(root.right, result);
    }


    TreeNode Deserialize(String str) {
        String[] strings = str.split(" ");
        return deserializeDfs(strings);
    }

    private int index = 0;

    private TreeNode deserializeDfs(String[] strings) {
        if (strings[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(strings[index++]));
        root.left = deserializeDfs(strings);
        root.right = deserializeDfs(strings);

        return root;
    }
}
