package offer;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Demo34 {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;

        sum -= root.val;
        path.add(root.val);

        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);

        path.remove(path.size() - 1);
    }
}
