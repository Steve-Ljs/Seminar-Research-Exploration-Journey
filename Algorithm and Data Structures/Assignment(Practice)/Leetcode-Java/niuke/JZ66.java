package niuke;

public class JZ66 {
    private int result = 0;
    private boolean [][] marked;

    public int movingCount(int threshold, int rows, int cols)
    {
        marked = new boolean[rows][cols];
        dfs(0, 0, threshold, rows, cols);
        return result;
    }

    private void dfs(int i, int j, int threshold, int rows, int cols) {
        if (i < rows && j < cols && bitCount(i) + bitCount(j) <= threshold && !marked[i][j]) {
            ++result;
            marked[i][j] = true;
            dfs(i + 1, j, threshold, rows, cols);
            dfs(i, j + 1, threshold, rows, cols);
        }
    }

    private int bitCount(int i) {
        int result = 0;
        while (i != 0) {
            result += i % 10;
            i /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        new JZ66().movingCount(5, 10, 10);
    }
}
