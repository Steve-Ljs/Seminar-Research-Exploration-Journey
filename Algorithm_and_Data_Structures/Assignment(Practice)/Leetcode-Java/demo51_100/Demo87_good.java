package demo51_100;

public class Demo87_good
{
    //0-1背包的思路
    /*
    最后,从m中选若干使得恰好为n
    dp[i][j]:从0-i选择若干元素,使得恰好为j
     */
    //使用一维数组压缩
    public boolean canPartition(int[] nums)
    {
        int sum = 0;
        for (int num : nums)  sum += num;
        if(sum%2==1) return false;//奇数不可能分为两份相等的

        int n = sum / 2+1;
        boolean[] dp = new boolean[n];
        //看作初始化第一行
        dp[0] = true;
        if(nums[0]<=sum/2) dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++)
        {
            //从右往左意义在于有些需要用左上角的值,这样不会覆盖
            //如果nums[i]>j,那么结束,因为左边的j越来越小
            //所以不可能再加上nums[i],直接默认dp[j]=dp[j],
            //即这一行的dp[j]与不加上nums[i]的上一行的dp[j]相同即可
            for (int j=n-1;nums[i]<=j;--j)
            {
                if(dp[n-1]) return true;//最后一列只要是true,结果就是true
                //左边的dp[j]代表的是这一行的,而右边的dp[j]代表的是上一行的
                //dp[j - nums[i]]也代表的是上一行的
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[n - 1];
    }

    public boolean canPartition1(int[] nums)
    {
        int sum = 0;
        for (int num : nums)  sum += num;
        if(sum%2==1) return false;//奇数不可能分为两份相等的

        int m = nums.length, n = sum / 2+1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = false;

        if(nums[0]==sum/2) return true;//因为一个恰好是一半
        //这样赋值给第一行会快很多
        if(nums[0]<=sum/2) dp[0][nums[0]] = true;

        for (int i = 1; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(nums[i]==j)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i - 1][j] || (j - nums[i]>=0 && dp[i - 1][j - nums[i]]);
            }

            if(dp[i][n-1]) return true;//因为数组中只有某个为true,那一列下面的都为true
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 5, 11, 5};
        new Demo87_good().canPartition(nums);

    }
}
