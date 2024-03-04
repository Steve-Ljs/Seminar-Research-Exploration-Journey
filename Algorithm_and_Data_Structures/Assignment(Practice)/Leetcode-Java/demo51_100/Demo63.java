package demo51_100;

public class Demo63
{
    /*
    快排的partition()函数,传入起止操作索引,返回索引j使得右边大于,左边小于他
    查看返回的索引j右边有多少个元素,如果=k-1,那么nums[j]就是第k大
    >k-1,lo=j+1,二分搜索右边
    <k-1,hi=j-1,二分搜索左边
     */
    public int findKthLargest(int[] nums, int k)
    {
        if (nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi)
        {
            int j = partition(nums, lo, hi);
            if (nums.length - j == k)//nums.length-j-1==k-1
            {
                return nums[j];
            } else if (nums.length - j > k)
            {
                lo = j + 1;
            } else
            {
                hi = j - 1;
            }
        }
        return -1;//其实上面必然会找到
    }

    private int partition(int[] nums, int lo, int hi)
    {
        int lt = lo, gt = hi;
        int i = lo + 1;
        int temp = nums[lo];
        while (i <= gt)
        {
            if (nums[i] < temp) exch(nums, i++, lt++);
            else if (nums[i] > temp) exch(nums, i, gt--);
            else ++i;
        }
        return lt;
        /*int i = lo + 1;
        while(i<hi)
        {
            while(i<hi && nums[i]<=nums[lo])
            {
                ++i;
            }
            while(hi>lo && nums[hi]>nums[lo])
            {
                --hi;
            }
            if(i>=hi) break;
            exch(nums, i, hi);
        }
        exch(nums, lo, hi);
        return hi;*/
    }

    private void exch(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        new Demo63().findKthLargest(nums, 5);

    }
}
