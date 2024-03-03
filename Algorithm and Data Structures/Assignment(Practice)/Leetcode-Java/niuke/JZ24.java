package niuke;

import utils.TreeNode;

import java.util.ArrayList;

public class JZ24 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(root,target);
        return result;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            result.add(new ArrayList<>(temp));
        }
        else {
            dfs(root.left, target - root.val);
            dfs(root.right, target - root.val);
        }
        temp.remove(temp.size() - 1);
    }
}
