package offer;

public class Demo53_1 {
    public int search(int[] nums, int target) {
        //[起始位置,结束位置+1]
        return find(nums, target) - find(nums, target - 1);
    }

    //找到第一个大于他的位置
    public int find(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            else if (nums[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
