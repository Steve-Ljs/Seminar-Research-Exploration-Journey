package demo51_100;

import java.util.Arrays;

public class Demo76
{
    /*
    dp[i]代表前i个的最大递增子数列数量
    转移状态方程:
    for j in [0,i)
        if (nums[i]>nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
    排除掉了前面比他大的那些.从中选取一条最长递增序列
    初始值:dp[i]=1,因为每个都构成序列为1的子数列
    返回值:途中的最大的一个,因为可能类似1 3 4 9 2 1的情况,最长递增子序列在中间
     */
    public int lengthOfLIS(int[] nums)
    {
        int result = 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)  //[0,i)
            {
                if (nums[i]>nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(Arrays.toString(nums));
        new Demo76().lengthOfLIS(nums);
    }
}
