package hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo01
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();//value,index
        for (int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target-nums[i])) return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(Arrays.toString(new Demo01().twoSum(nums,4)));
    }
}
