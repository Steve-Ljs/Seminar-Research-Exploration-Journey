package demo51_100;

import java.util.Arrays;

public class Demo74
{
    //快慢指针法
    /*
    把他看成一个链表的话,必然会是一个循环链表
    快慢指针不断反复,必然会在循环里面的一段相遇,不清楚的话画图分析即可
     */
    public int findDuplicate(int[] nums)
    {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //此时已经相遇在循环里面了,但不一定是那个重复的
        //推导一下可以得知从起点到循环点和从相遇到循环点路程一样
        fast = 0;
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
    /*
    二分法
    nums.length为n+1,而数字在[1,n],所以先取中点,
    看看在[1,mid]里面的数字有多少个,如果大于右边的,再继续二分
     */
    public int findDuplicate2(int[] nums)
    {
        int lo = 1, hi = nums.length-1;//开始位于[1,n]
        while(lo<hi)
        {
            int mid = (lo + hi) >>> 1;//相当于/2
            int count = 0;
            for (int num : nums)if(num<=mid) ++count;

            if(count>mid) hi = mid;//[1,mid]的个数为count,如果他都大于mid,说明一定在这个区间内
            else lo = mid + 1;//反之就在[mid+1,hi]中
        }
        return lo;
    }
    //违规了,不能动原数组
    public int findDuplicate1(int[] nums)
    {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i]==nums[i-1])
                return nums[i];
        }
        return 0;
    }

    public static void main(String[] args)
    {
        int i = 19;
        System.out.println(i>>>1);
    }
}
