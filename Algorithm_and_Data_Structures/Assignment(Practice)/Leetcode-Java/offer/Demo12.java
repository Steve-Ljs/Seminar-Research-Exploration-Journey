package offer;

public class Demo12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //记住在某次走过的路径,走完还原
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //第一次匹配第0个字符
                if (dfs(matrix, rows, cols, i, j, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[] matrix, int rows, int cols, int i, int j, char[] str, int index) {
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1) return false;
        if (matrix[i * cols + j] != str[index]) return false;
        if (str.length == index + 1) return true;

        char temp = matrix[i * cols + j];
        matrix[i * cols + j] = 1;
        boolean result = dfs(matrix, rows, cols, i + 1, j, str, index + 1) ||
                dfs(matrix, rows, cols, i - 1, j, str, index + 1) ||
                dfs(matrix, rows, cols, i, j + 1, str, index + 1) ||
                dfs(matrix, rows, cols, i, j - 1, str, index + 1);
        matrix[i * cols + j] = temp;
        return result;
    }

}
