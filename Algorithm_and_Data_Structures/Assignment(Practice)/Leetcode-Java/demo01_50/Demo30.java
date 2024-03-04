package demo01_50;

public class Demo30
{
    /*
    dp[i][j]是使得符合的最小操作数
    返回dp[m][n]
    初始化:dp[0][j]=j ,dp[i][0]=i
    if(word1.charAt(i-1)==word2.charAt(j-1))
    {
    }
     */
    public int minDistance(String word1, String word2)
    {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) dp[i][0] = i;
        for (int j = 0; j < n + 1; j++) dp[0][j] = j;

        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                /*FBI warning 需要注意字符相等时,只能与i-1,j-1的相等,不能取三个的最小值
                因为考虑实际意义,例如xrr与yr对比,r与r相等了,应该等同于xr与y对比
                可以画图
                 */
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }
}
