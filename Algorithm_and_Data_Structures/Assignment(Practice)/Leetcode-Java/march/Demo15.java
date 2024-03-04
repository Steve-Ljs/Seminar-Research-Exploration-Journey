package march;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length <= 2) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            //去掉重复情况
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] == 0) {
                    result.add(new LinkedList<>(Arrays.asList(nums[i], nums[lo], nums[hi])));
                    //因为不允许重复，所以两个都需要进行改变
                    //避免重复元素
                    while (++lo < hi && nums[lo] == nums[lo - 1]) ;
                    while (--hi > lo && nums[hi] == nums[hi + 1]) ;
                } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }

        return result;
    }
}
