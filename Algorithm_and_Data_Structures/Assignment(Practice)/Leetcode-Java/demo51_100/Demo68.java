package demo51_100;

public class Demo68
{
    /*
    乘积=左边的乘积*右边的乘积
     */
    public int[] productExceptSelf(int[] nums)
    {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            result[i] = result[i - 1] * nums[i-1];
        }
        int k = 1;
        for(int i=nums.length-1;i>=0;--i)
        {
            result[i] *= k;
            k *= nums[i];//如果全部乘积有越界的风险的话,这里到0时应该不执行,直接退出了
        }
        return result;
    }
}
