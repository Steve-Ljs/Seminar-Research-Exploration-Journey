package hot;

public class Demo72
{
    //节约空间
    public int minDistance(String word1, String word2)
    {
        int m = word1.length(), n = word2.length();

        int[] dp = new int[n + 1];
        for (int j = 0; j < n + 1; j++) dp[j] = j;

        for (int i = 1; i < m + 1; i++)
        {
            int leftTop = dp[0];//look 记录左上角的值 注意和下面一条的顺序
            dp[0] = i;//look 不要忽略这里的初始化
            for (int j = 1; j < n + 1; j++)
            {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[j] = leftTop;
                else dp[j] = Math.min(dp[j], Math.min(dp[j - 1], leftTop)) + 1;
                leftTop = temp;
            }
        }
        return dp[n];
    }

    public int minDistance1(String word1, String word2)
    {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) dp[i][0] = i;
        for (int j = 0; j < n + 1; j++) dp[0][j] = j;

        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                //look,需要+1,并且注意+1的时机
                //因为相同字符时操作肯定不会大于增删的操作次数 所以可以这样写
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args)
    {
        System.out.println(new Demo72().minDistance("horse", "ros"));
    }
}
