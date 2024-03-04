package hot;

public class Demo747 {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                result = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if (max >= 2 * second) {
            return result;
        }
        return -1;
    }
}
