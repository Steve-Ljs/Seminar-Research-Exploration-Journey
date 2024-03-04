package offer;

public class Demo39 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                result = nums[i];
            }
            else {
                if (nums[i] == result) ++count;
                else --count;
            }
        }
        return result;
    }
}
