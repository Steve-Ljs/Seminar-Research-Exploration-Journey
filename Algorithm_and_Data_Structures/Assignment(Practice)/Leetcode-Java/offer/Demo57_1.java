package offer;

import java.util.HashMap;
import java.util.Map;

public class Demo57_1 {
    //是排序数组,所以可以采用双指针法
    public int[] twoSum(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            }
            else if (sum > target) {
                hi--;
            }
            else {
                return new int[]{nums[lo], nums[hi]};
            }
        }
        return new int[]{-1, -1};
    }

    //空间复杂度也是O(N)
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
