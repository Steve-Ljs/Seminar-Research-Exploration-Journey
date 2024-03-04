package hot;

public class Demo136
{
    public int singleNumber(int[] nums)
    {
        if(nums.length==0) throw new IllegalArgumentException();
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) result ^= nums[i];
        return result;
    }
}
