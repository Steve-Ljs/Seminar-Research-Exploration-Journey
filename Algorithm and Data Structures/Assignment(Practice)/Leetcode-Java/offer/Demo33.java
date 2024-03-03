package offer;

public class Demo33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int lo, int hi) {
        if (hi <= lo) return true;

        int i = lo;
        while (i < hi && postorder[i] <= postorder[hi]) ++i;

        //必须把右子树都判断完才能说明是合格的
        for (int j = i; j < hi; j++) {
            if (postorder[j] < postorder[hi]) {
                return false;
            }
        }

        return dfs(postorder, lo, i - 1) && dfs(postorder, i, hi - 1);
    }
}
