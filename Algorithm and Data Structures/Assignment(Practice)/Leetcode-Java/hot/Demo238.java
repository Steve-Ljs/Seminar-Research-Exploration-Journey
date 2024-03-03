package hot;

public class Demo238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int[] result = new int[n];
        //先乘上该元素左边的值
        int temp = 1;
        result[0] = 1;
        for (int i = 1; i < n; ++i) {
            temp *= nums[i - 1];
            result[i] = temp;
        }

        //再乘上该元素右边的值
        temp = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            result[i] = temp * result[i];
            temp *= nums[i];
        }
        return result;
    }
}
