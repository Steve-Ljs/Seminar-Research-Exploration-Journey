package demo01_50;

import java.util.Arrays;

public class Demo15
{
    /*
    1254963   -> 1256943   ->  1256349
    从右向左找到第一个降序元素4,再从右向左找到第一个比他大的数6,两者交换
    再把右边的降序数组反转,变成升序即可
     */
    public void nextPermutation(int[] nums)
    {
        if (nums.length <= 1) return;
        int i;
        for (i = nums.length - 2; i >= 0; --i) if (nums[i] < nums[i + 1]) break;
        if (i == -1)//说明是全降序数组
        {
            reverse(nums, 0, nums.length);
            return;//FBI warning,出了结果就该返回了
        }
        //FBI waring 此时找就需要从nums.length - 1开始
        for (int j = nums.length - 1; j >= 0; --j)
        {
            if(nums[j]>nums[i])
            {
                exch(nums,i,j);
                reverse(nums,i+1,nums.length);
                return;
            }
        }
    }

    private void reverse(int[] nums, int lo, int n)
    {
        for (int i = 0; i < (n - lo) / 2; i++)
        {
            exch(nums, lo + i, n - 1 - i);
        }
    }

    void exch(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 4, 3, 2, 1};
        new Demo15().nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
