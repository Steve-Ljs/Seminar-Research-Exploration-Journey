package offer;

public class Demo13 {
    private boolean[][] marked;
    private int m;
    private int n;
    private int threshold;

    //核心是不能进入行坐标和列坐标的数位之和大于k的格子。所以搜索到就可以停止了
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0) return 0;
        marked = new boolean[rows][cols];
        m = marked.length;
        n = marked[0].length;
        this.threshold = threshold;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return 0;
        if (marked[i][j]) return 0;
        if ((bitSum(i) + bitSum(j)) > threshold) return 0;

        marked[i][j] = true;

        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int bitSum(int t) {
        int count = 0;
        while (t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }
}
