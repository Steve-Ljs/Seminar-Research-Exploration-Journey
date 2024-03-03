import java.util.Arrays;

public class MainTest {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return dfs(sequence, 0, sequence.length - 1);
    }

    private boolean dfs(int [] sequence, int lo, int hi) {
        if (hi <= lo) return true;

        int root = sequence[hi];
        int rightIndex = lo;
        while (sequence[rightIndex] < root) {
            rightIndex++;
        }
        //检查
        for (int i = rightIndex; i < hi; i++) {
            if (sequence[i] >= root) {
                return false;
            }
        }

        return dfs(sequence, lo, rightIndex - 1) && dfs(sequence, rightIndex, hi - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,8,6,12,16,14,10};
        new MainTest().VerifySquenceOfBST(a);
    }
}
