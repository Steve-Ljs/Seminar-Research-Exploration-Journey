package hot;

public class Demo215
{
    /**
     * 假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
     * 快排思想,partion后得到的位置中,左边是小于他的,右边是大于等于他的
     */
    public int findKthLargest(int[] nums, int k)
    {
        int N = nums.length;
        int lo = 0, hi = N - 1;

        while (lo<=hi)
        {
            int j = partion(nums, lo, hi);
            //该元素的第N-j大的
            if (k == N - j) return nums[j];
            else if (k < N - j) lo = j + 1;
            else hi = j - 1;
        }
        return -1;
    }

    private int partion(int[] nums, int lo, int hi)
    {
        int j = lo+1;
        while(j<=hi)
        {
            if(nums[j]<nums[lo]) ++j;
            else exch(nums, j, hi--);
        }
        exch(nums, lo, hi);
        return hi;
    }

    private void exch(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
