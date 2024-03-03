package hot;

public class Demo152
{
    //压缩空间
    public int maxProduct(int[] nums)
    {
        int N = nums.length;
        if (N == 0) return 0;
        int max = nums[0], min = nums[0], result = nums[0];

        for (int i = 1; i < N; i++)
        {
//            if (nums[i] > 0)
//            {
//                max = nums[i] * Math.max(1, max);//适当时候抛弃前面的
//                min = Math.min(min, 1) * nums[i];
//            }
//            else
//            {
//                int temp=max;
//                max = nums[i] * Math.min(min, 1);//适当时候抛弃前面的
//                //look,这里min依赖与max[i-1]
//                min = Math.max(temp, 1) * nums[i];
//            }
            int temp = max;
            max = Math.max(max * nums[i], Math.max(nums[i] * min, nums[i]));
            min = Math.min(min * nums[i], Math.min(temp * nums[i], nums[i]));
            result = Math.max(max, result);
        }
        return result;
    }

    //经典动态规划
    public int maxProduct1(int[] nums)
    {
        int N = nums.length;
        if (N == 0) return 0;

        int[] max = new int[N];
        int[] min = new int[N];

        int result = nums[0];//注意初始值
        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < N; i++)
        {
            if (nums[i] > 0)
            {
                max[i] = nums[i] * Math.max(1, max[i - 1]);//适当时候抛弃前面的
                min[i] = Math.min(min[i - 1], 1) * nums[i];
            }
            else
            {
                max[i] = nums[i] * Math.min(min[i - 1], 1);//适当时候抛弃前面的
                min[i] = Math.max(max[i - 1], 1) * nums[i];
            }
            result = Math.max(max[i], result);
        }
        return result;
    }
}
