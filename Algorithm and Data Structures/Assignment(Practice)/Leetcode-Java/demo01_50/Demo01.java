package demo01_50;

import java.util.HashMap;
import java.util.Map;

public class Demo01
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();//值,索引
        for (int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }
}
