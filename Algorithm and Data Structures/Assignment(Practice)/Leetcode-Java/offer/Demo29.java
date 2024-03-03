package offer;

import java.util.Deque;
import java.util.NoSuchElementException;

public class Demo29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int [0];

        int m = matrix.length, n = matrix[0].length;
        int [] result = new int[m * n];
        int index = 0;

        int left = 0, right = n - 1;
        int lo = 0, hi = m - 1;
        while (lo <= hi && left <= right) {
            for (int j = left; j <= right; j++) {
                result[index++] = matrix[lo][j];
            }
            for (int i = lo + 1; i <= hi; i++) {
                result[index++] = matrix[i][right];
            }
            //单行或单列的情况下,上面两个已经完成了任务,下面会重复
            if (lo == hi) break;
            if (left == right) break;
            for (int j = right - 1; j >= left; j--) {
                result[index++] = matrix[hi][j];
            }
            for (int i = hi - 1; i >= lo + 1; i--) {
                result[index++] = matrix[i][left];
            }
            ++lo;
            --hi;
            ++left;
            --right;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
