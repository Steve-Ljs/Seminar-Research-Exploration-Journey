package demo01_50;

public class Demo25
{
    public boolean canJump(int[] nums)
    {
        if(nums==null || nums.length==0) return false;

        int lo = 0, hi = nums[0];
        while(true)
        {
            if(hi>=nums.length-1) return true;
            int temp = hi;//刚开始能走到的最远距离
            for (int i = lo; i <= temp; i++)//FBI warning 必须是i<=temp,即原本的hi,不然会数组越界!
            {
                hi = Math.max(nums[i] + i,hi);
            }
            if(hi==temp) return false;//还是只能走开始走的这么远
            lo = temp;
        }
    }

    public static void main(String[] args)
    {
        new Demo25().canJump(new int[]{2, 3, 1, 1, 4});
    }
}
