package hot;

public class Demo198
{
    public int rob(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return 0;
        if(n==1) return nums[0];
        int first = nums[0],second=Math.max(first,nums[1]);
        int result = second;//look
        for (int i = 2; i < nums.length; i++)
        {
            result = Math.max(first + nums[i], second);
            first = second;
            second = result;
        }
        return result;
    }

    public int rob1(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);//look
        for (int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
