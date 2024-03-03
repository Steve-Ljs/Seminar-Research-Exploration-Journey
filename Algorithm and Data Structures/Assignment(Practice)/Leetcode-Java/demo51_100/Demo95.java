package demo51_100;

import java.util.HashMap;
import java.util.Map;

public class Demo95
{
    public static void main(String[] args)
    {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(new Demo95().subarraySum(nums,7));
    }

    /*sum[i]代表nums[0]+nums[1]+...+nums[i]
    如果sum[j]-sum[i]=k,就代表从i到j的累计之和为k
    所以用map存储sum[i],sum[i]出现的次数
    其中要存储[0,1],这使得了单个元素达到k也能计数,表示累加和为0，出现了1次
    若sum−k存在于hash中，说明存在连续序列使得和为k
    则令count+=hash[sum-k]，表示sum−k出现几次，就存在几种子序列使得和为k。

    例:数组为[1,2,3],k=5
    那么开始有(0,1),(1,1),(3,1)
    到i=2时,sum=6,则找sum-k=1是否存在于map中,存在,那么就有一个
    连续子数组使得相加为k,即为[2,3]

    再例如[2,-2,2,3] k=5
    (0,2),(2,2),i=3时,sum-k=0
    则有两个子数组,[2,-2,2,3][2,3]
     */
    public int subarraySum(int[] nums, int k)
    {
        int count = 0,sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(map.containsKey(sum-k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    //暴力
    public int subarraySum1(int[] nums, int k)
    {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int sum=0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum == k)
                {
                    ++result;
                }
            }
        }
        return result;
    }
}
