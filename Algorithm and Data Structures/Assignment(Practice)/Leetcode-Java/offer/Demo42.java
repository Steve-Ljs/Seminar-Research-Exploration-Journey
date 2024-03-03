package offer;

public class Demo42 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = (pre > 0 ? pre + nums[i] : nums[i]);
            result = Math.max(result, pre);
        }
        return result;
    }
}
