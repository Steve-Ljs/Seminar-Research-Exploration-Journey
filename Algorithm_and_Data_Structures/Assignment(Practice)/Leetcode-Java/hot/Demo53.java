package hot;

public class Demo53
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

       注意,最大值极大可能出现在过程中
       所以这些题,包括一些动态规划题中,result都是在过程中随时判断是否是最大值
       而还有一个东西,例如temp,是一直走到尽头的
    */
    //子数组最少包含一个元素
    public int maxSubArray(int[] nums)
    {
        int N = nums.length;
        int result = Integer.MIN_VALUE,temp=0;//look,因为条件是至少包含
        for (int i = 0; i < N; i++)
        {
            temp = temp > 0 ? temp + nums[i] : nums[i];
            result = Math.max(result, temp);
        }
        return result;
    }
}
