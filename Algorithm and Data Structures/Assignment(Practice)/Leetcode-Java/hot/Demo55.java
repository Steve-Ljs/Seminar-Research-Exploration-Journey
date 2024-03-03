package hot;

public class Demo55
{

    public boolean canJump(int[] nums)
    {
        int i = 0;//所处位置
        int jump = 0;//能跳到的最远位置
        while (i <= jump)
        {
            jump = Math.max(jump, i + nums[i]);//i+nums[i]为通过i位置能跳到的最远处
            if (jump >= nums.length - 1) return true;
            ++i;//不断往前走一格
        }
        return false;
    }
}
