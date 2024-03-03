package demo51_100;

import java.util.Arrays;

public class Demo92_good
{
    /*private int result=0;

    public int findTargetSumWays(int[] nums, int S)
    {
        recursive(nums,0,0,S);
        return result;
    }
    private void recursive(int[]nums,int i,int sum,int S)
    {
        if(i==nums.length)
        {
            //不能放在一起是因为如果到了数组尽头就不能再递归
            if(sum==S) ++result;
        }
        else
        {
            recursive(nums,i+1,sum+nums[i],S);
            recursive(nums,i+1,sum-nums[i],S);
        }
    }*/
    /*
    动态规划,dp[i][j]表示由数组前i个元素组成和为j的方案数
    所以dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]]
    因为第i个元素值为nums[i],且可以加或者减去他
    所以只要找到前i-1个元素组成的和为j +- nums[i]的方案数即可
     */
    public int findTargetSumWays(int[] nums, int S)
    {
        int M = nums.length, N = 2001;
        if(M==0) return 0;
        int[][] dp = new int[M][N];
        //其实是[-1000,1000]但是没有负的坐标,所以人为+1000的偏移量使得开始在0
        dp[0][1000-nums[0]] = 1;
        dp[0][1000+nums[0]] += 1;//用+=是因为,如果本身这玩意是0,那么结果应该有两个

        for (int i = 1; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int addNum = j - nums[i] < 0 ? 0 : dp[i - 1][j - nums[i]];
                int subNum = j + nums[i] > N-1 ? 0 : dp[i - 1][j + nums[i]];
                dp[i][j] =  addNum+subNum;
            }
        }
        //S给的可能超过数组范围
        return S>1000?0:dp[M-1][S+1000];
    }

    /*
    //还没看
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum+target)%2 == 1){
            return 0;
        }
        target = (target + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];

            }
        }
        return dp[target];
    }

     */

}
