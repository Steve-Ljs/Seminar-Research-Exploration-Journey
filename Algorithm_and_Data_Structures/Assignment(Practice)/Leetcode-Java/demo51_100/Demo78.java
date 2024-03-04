package demo51_100;

public class Demo78
{
    /*dp[i][0] 第i天不持有股票的最大收益,dp[i][1]第i天持有股票的最大收益
    dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i])要么前一天就没持有,要么持有卖了
    dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i])隔一天才能买,所以前天必须已经没有股票了
    初始化:dp[-1][0]=0 代表此时最大利益为0,dp[-1][1]=Integer.MIN_VALUE 代表不可能
    //第二种:初始化:dp[0][0]=0 代表此时最大利益为0,dp[0][1]=-prices[0]
    最后要求dp[N-1][0]
    * */
    public int maxProfit(int[] prices)
    {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < prices.length; i++)
        {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
        /*按照上面的框架严格写的,还可以继续优化
        int N = prices.length;
        if(N==0) return 0;
        int[][] dp = new int[N][2];
        dp[0][0]=0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < N; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i==1?0:dp[i - 2][0]) - prices[i]);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[N - 1][0];*/
    }

    public static void main(String[] args)
    {
        int[] prices = {1, 2, 4};
        new Demo78().maxProfit(prices);
    }
}
