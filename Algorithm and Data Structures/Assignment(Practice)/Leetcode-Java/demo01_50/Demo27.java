package demo01_50;

import java.util.Arrays;

public class Demo27
{
    //节约空间的动态规划
    public int uniquePaths(int m, int n)
    {
        if(m<=0 || n<=0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
    /*
    最简单的动态规划:
    dp[i][j]代表路径
    返回dp[m-1][n-1]
    dp[i][j]=dp[i-1][j]+dp[i][j-1]
    dp[i][0]=1
    dp[0][i]=1
     */
    public int uniquePaths1(int m, int n)
    {
        if(m<=0 || n<=0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++)
        {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
