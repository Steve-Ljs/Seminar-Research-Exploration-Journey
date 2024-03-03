package demo51_100;


public class Demo79_look
{
    public int maxCoins(int[] nums)
    {
        //创建虚拟边界 nums2:[1,3,1,5,8,1]
        int[] nums2 = new int[nums.length + 2];
        System.arraycopy(nums, 0, nums2, 1, nums.length);
        nums2[0] = 1;nums2[nums.length + 1] = 1;
        int N = nums2.length;

        // dp[i][j]代表的是不戳破 i 与 j ，仅戳破 i 与 j 之间的气球我们能得到的最大金币数。
        int[][] dp = new int[N][N];//创建dp表
        //N-2为原数组的最后一个
        //两层循环意味着,先从最下方开始逐步上移,然后再在那个位置上把j下移,开大口子
        for (int i = N - 2; i > -1; i--)//开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
        {
            for (int j = i + 2; j < N; j++)
            {
                //维护一个最大值；如果i、j相邻，值为0
                int max = 0;//k为(i,j)之间
                for (int k = i + 1; k < j; k++)
                {
                    int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                    if (temp > max) max = temp;
                }
                dp[i][j] = max;
            }
        }
        return dp[0][N - 1];
    }
}
