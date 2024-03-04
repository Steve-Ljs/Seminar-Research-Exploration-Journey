package hot;

public class Demo279 {
    //动态规划
    //dp[n]=min{dp[n-i*i]+1}
    //初始化:dp[0]=0
    //返回dp[n]
    public int numSquares(int n) {
        if (n < 0) return -1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//小小改进,这样比Integer.MAX_VALUE稍微快点
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Demo279().numSquares(12));
    }
}
