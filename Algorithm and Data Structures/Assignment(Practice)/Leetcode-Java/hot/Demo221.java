package hot;

public class Demo221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]代表最大的正方形边长
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    result = Math.max(result, dp[i][j] * dp[i][j]);
                }
            }
        }

        return result;
    }

    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) right[i] = n; //look

        for (int i = 0; i < m; i++) {
            //对height赋值
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j] += 1;
                else height[j] = 0;
            }

            //对left赋值
            int leftIndex = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //继承上一个的
                    left[j] = Math.max(leftIndex, left[j]);
                }
                else {
                    left[j] = 0;//考虑下面继承他的范围,就要放宽
                    leftIndex = j + 1;
                }
            }

            //right赋值
            int rightIndex = n;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(rightIndex, right[j]);
                }
                else {
                    right[j] = n;
                    rightIndex = j;
                }
            }

            //计算正方形
            for (int j = 0; j < n; j++) {
                int value = Math.min(right[j] - left[j], height[j]);
                result = Math.max(result, value * value);
            }
        }

        return result;
    }
}
