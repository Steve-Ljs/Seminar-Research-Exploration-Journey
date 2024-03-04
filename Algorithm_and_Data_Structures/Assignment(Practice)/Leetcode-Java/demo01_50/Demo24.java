package demo01_50;

public class Demo24
{
    /*
    其实,就是动态规划:
    定义:dp[i]代表加到i的最大值
    状态方程:dp[i]=Math.max(nums[i],dp[i-1]+nums[i])
    初始值:dp[0]=nums[0]
    返回值:返回历届dp[i]的最大值
    节约空间:
    dp=nums[0],result=dp;//结果等于第一个dp,相当于dp[0]
    dp=Math.max(nums[i],dp+nums[i])
    result=Math.max(dp,result)//相当于与之前的dp相比

    注意,最大值极大可能出现再过程中
    所以这些题,包括一些动态规划题中,result都是在过程中随时判断是否是最大值
    而还有一个东西,例如temp,是一直走到尽头的
     */
    public int maxSubArray(int[] nums)
    {
        if(nums==null || nums.length==0) return 0;
        int result = nums[0],dp=nums[0];//FBI warning
        for (int i = 1; i < nums.length; i++)
        {
            dp = Math.max(nums[i], dp + nums[i]);
            result = Math.max(result, dp);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 1, -3, 4, -1, 2, 1, -5, 4};
    }
}
