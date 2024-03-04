package hot;

public class Demo96
{
    public int numTrees(int n)
    {
        if(n<1)
        {
            throw new IllegalArgumentException();
        }

        int[] dp = new int[n + 1];
        //dp[0]=1也可以代表的是,左边(右边)为空的情况有一种
        dp[0] = 1;
        dp[1] = 1;
        //look,i要从2开始,1的话是初始值,如果从1开始,则dp[1]=2
        for (int i = 2; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
