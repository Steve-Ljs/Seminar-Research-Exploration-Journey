package demo01_50;

public class Demo48
{
    public int singleNumber(int[] nums)
    {
        if(nums==null || nums.length==0) return 0;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)  result ^= nums[i];
        return result;
    }
}
