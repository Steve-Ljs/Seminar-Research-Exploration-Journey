package demo51_100;

import java.util.Arrays;

public class Demo96
{
    /*
    分为有序 无序 有序三部分
    无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界
    要找到无序的最小值,则需要从左向右,首先去掉左边有序数组的干扰.而右边则同理从右边开始遍历,
    并且去掉右边数组的干扰,可以画图参考
     */
    public int findUnsortedSubarray(int[] nums)
    {
        //突然遇到降序时,就到了无序数组的范围,找到无序的最小,最大元素
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i]<nums[i-1]) flag = true;
            if(flag) min = Math.min(min,nums[i]);
        }
        //一直增加,那就是有序的
        if(!flag) return 0;
        flag = false;
        for (int i = nums.length-2;i>=0;--i)
        {
            if(nums[i]>nums[i+1]) flag = true;
            if(flag) max = Math.max(max,nums[i]);
        }
        int lo, hi;
        for (lo = 0; lo < nums.length; lo++)
        {
            if (min < nums[lo]) break;
        }
        for (hi = nums.length - 1; hi >= 0; hi--)
        {
            if (max > nums[hi]) break;
        }
        return hi - lo + 1;
    }

    //排序算法
    public int findUnsortedSubarray1(int[] nums)
    {
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi && nums[lo] == temp[lo])
        {
            ++lo;
        }
        while (lo <= hi && nums[hi] == temp[hi])
        {
            --hi;
        }
        return hi - lo + 1;
    }

}
