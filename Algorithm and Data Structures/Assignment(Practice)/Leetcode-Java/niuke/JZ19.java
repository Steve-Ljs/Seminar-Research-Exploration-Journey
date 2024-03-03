package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JZ19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int lo = 0, hi = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (lo <= hi && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[lo][j]);
            }
            for (int i = lo + 1; i <= hi; i++) {
                result.add(matrix[i][right]);
            }
            if (lo != hi) {
                for (int j = right - 1; j >= left; j--) {
                    result.add(matrix[hi][j]);
                }
            }

            if (left != right) {
                for (int i = hi - 1; i > lo; i--) {
                    result.add(matrix[i][left]);
                }
            }

            ++lo;
            --hi;
            ++left;
            --right;
        }
        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
    }
}
