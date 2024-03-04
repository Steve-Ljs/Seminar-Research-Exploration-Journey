package demo51_100;

public class Demo72
{
    /*
    dp[i]代表组成和的完全平方数的个数
    dp[0]=0,dp[1]=1
    dp[i]=Math.min(dp[i-1],dp[i-4],dp[i-9]...)+1
    dp[i]
     */
    public int numSquares(int n)
    {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            dp[i] = i;//小小改进,这样比Integer.MAX_VALUE稍微快点
            for (int j = 1;i-j*j>=0; j++)
            {
                dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];
    }
}
