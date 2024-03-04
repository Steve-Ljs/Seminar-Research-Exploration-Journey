package demo01_50;

public class Demo28
{
    /*
    很简单的动态规划,但是太大意了
     */
    public int minPathSum(int[][] grid)
    {
        if(grid==null || grid.length==0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];//FBI warning多想想
        for (int j = 1; j < n; j++)
        {
            dp[j] = grid[0][j]+dp[j-1];//FBI warning多想想
        }
        for (int i = 1; i < m; i++)
        {
            dp[0] = grid[i][0]+dp[0];//FBI warning多想想
            for (int j = 1; j < n; j++)
            {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int[] result = new int[5];
        for (int i : result)
        {
            System.out.println(i);
        }
    }
}
