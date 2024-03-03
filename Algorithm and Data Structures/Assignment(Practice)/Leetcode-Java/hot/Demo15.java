package hot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo15
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i]>0) break;//优化
            //处理第一个元素的重复
            if(i>0 && nums[i]==nums[i-1]) continue;

            int lo = i + 1, hi = nums.length - 1;
            while(lo<hi)//至少有三个元素
            {
                if(nums[i]+nums[lo]+nums[hi]==0)
                {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    //去重
                    //look,必须至少强制位移一次
                    //因为去掉重复,所以一个位移了,另外一个必然是要位移的
//                    while(lo<hi && nums[lo+1]==nums[lo]) ++lo;
//                    while(lo<hi && nums[hi]==nums[hi-1]) --hi;
                    //look,注意细节,如果先++lo了,那肯定会错,因为两个相等了
//                    while(lo<hi && nums[++lo]==nums[lo]);
//                    while(lo<hi && nums[--hi]==nums[hi]);
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
