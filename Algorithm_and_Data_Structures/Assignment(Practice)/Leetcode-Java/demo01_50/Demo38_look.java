package demo01_50;

public class Demo38_look
{
    /*
    动态规划:
    dp[i]代表以i个节点组成的二叉搜索树有多少种
    返回dp[n]
    初始化:dp[0]=1,dp[1]=1
    状态转移方程:
    定义F(i,n)为以i为根节点,[0,i-1]为左边,[i+1,n]为右边组成的个数
    dp[i]=for(j=0:i) F(j,i)之和
    而F(i,n)=dp[i-1]*dp[n-i]
     */
    public int numTrees(int n)
    {
        if(n<=1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;dp[1] = 1;//dp[0]=1也可以代表的是,左边(右边)为空的情况有一种

        for (int i = 2; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)//以j为根元素
            {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
