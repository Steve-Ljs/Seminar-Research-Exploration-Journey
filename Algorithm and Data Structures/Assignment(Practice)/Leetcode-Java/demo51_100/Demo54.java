package demo51_100;

public class Demo54
{
    /*
    max[i]代表乘到nums[i]的最大值,min[i]最小值
    max[i]=Math.max(max[i-1]*nums[i],min[i-1]*nums[i],nums[i])
    min[i]=Math.min(max[i-1]*nums[i],min[i-1]*nums[i],nums[i])
    初始值:max[0]=nums[0],min[0]=nums[0],result=Integer.MIN_VALUE
    返回值:result=Math.max(result,max[i])
     */
    public int maxProduct(int[] nums)
    {
        if(nums.length==0) return 0;

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0]=nums[0];
        min[0]=nums[0];
        int result = max[0];

        for (int i = 1; i < nums.length; i++)
        {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
            result = Math.max(result, max[i]);
        }

        return result;
    }
}
