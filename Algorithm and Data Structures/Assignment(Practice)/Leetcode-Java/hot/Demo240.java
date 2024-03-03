package hot;


public class Demo240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上开始寻找,左边都是小于他的,下边都是大于他的
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] < target) {
                i++;
            }
            else {
                j--;
            }
        }

        return false;
    }
}
