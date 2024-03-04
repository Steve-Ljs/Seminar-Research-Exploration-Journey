package offer;

public class Demo51 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[n];
        return reversePairs(copy, 0, n - 1, temp);
    }

    private int reversePairs(int[] nums, int lo, int hi, int[] temp) {
        if (lo == hi) {
            return 0;
        }

        int mid = lo + (hi - lo) / 2;
        int leftPairs = reversePairs(nums, lo, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, hi, temp);

        //归并的快速退出情况
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, lo, mid, hi, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    //归并两个有序数组
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        //辅助数组
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            }
            else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            }
            else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }
            else {
                nums[k] = temp[j];
                j++;
                //只有temp[i] > temp[j]的情况，才计算逆序对
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
