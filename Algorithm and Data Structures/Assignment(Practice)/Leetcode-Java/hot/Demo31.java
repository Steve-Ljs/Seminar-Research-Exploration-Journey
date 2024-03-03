package hot;

import java.util.Arrays;

public class Demo31
{
    /*
    1254963   -> 1256943   ->  1256349
    从右向左找到第一个降序元素4,再从右向左找到第一个比他大的数6,两者交换
    再把右边的降序数组反转,变成升序即可
     */
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        int index;//从倒数第二个元素开始比
        for (index = n - 2; index >= 0; index--)
        {
            if (nums[index] < nums[index + 1]) break;//=号不行
        }
        if (index < 0) //说明是54321这种或者为空,或者只有一个元素
        {
            //颠倒即可
            reverse(nums, 0, n - 1);
            return;
        }
        //找到第一个大于他的
        for (int i = n - 1; i >= 0; i--)
        {
            if (nums[index] < nums[i])//=号不行
            {
                exch(nums, index, i);
                //从index+1,到n-1,反转数组
                reverse(nums, index + 1, n - 1);
                return;//look,做完直接return了
            }
        }
    }

    //lo,hi为要反转数组的开始,结束索引位置
    private void reverse(int[] nums, int lo, int hi)
    {
        for (int i = 0; i < (hi - lo + 1) / 2; i++) exch(nums, lo + i, hi - i);
        //look 判断条件这有问题
//        for (int i = lo; i < (hi - lo + 1) / 2; i++) exch(nums, i, hi - i);
    }

    private void exch(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 2};
        new Demo31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
