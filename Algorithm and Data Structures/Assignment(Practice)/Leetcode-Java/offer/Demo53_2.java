package offer;

public class Demo53_2 {
    public int missingNumber(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //说明前面的没有问题
            if (nums[mid] == mid) {
                lo = mid + 1;
            }
            else if (nums[mid] == mid + 1) {
                //说明左边缺少数字
                hi = mid - 1;
            }
        }
        //返回的是缺少的数字加1
        return hi + 1;
    }
}
