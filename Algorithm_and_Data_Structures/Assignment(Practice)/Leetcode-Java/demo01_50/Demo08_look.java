package demo01_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo08_look
{
    /*
        关键是不包含重复
        思路：先排序，然后逐个遍历i，双指针lo=i+1,hi=n-1,找到lo>=hi为止
        去除重复：i遇到重复的跳过，nums[i]+nums[lo]+nums[hi]==0时，++lo,--hi同时循环进行
        因为可能下一个还是同样值的lo，hi，且一个移动之后，不可能再相等，为了更快两个一起移动
        特判：n<3,nums[i]>0

        时间复杂度：O(N²)，空间复杂度O(1)
     */
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        if(n<3) return result;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++)
        {
            if(nums[i]>0) return result;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int lo = i + 1, hi = n - 1;
            while(lo<hi)
            {
                if(nums[i]+nums[lo]+nums[hi]==0)
                {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo<hi && nums[lo]==nums[++lo]);
                    while(lo<hi && nums[hi]==nums[--hi]);
                }
                else if(nums[i]+nums[lo]+nums[hi]>0) --hi;
                else ++lo;
            }
        }
        return result;
    }
}
