package offer;

public class Demo03 {
    /*
    方法一: 把输入数组排序,从头到尾找重复数字 O(N log N) 排序
    方法二: 哈希表,没有包含数字则加入哈希表,有则找到重复的 时间复杂度,空间复杂度都是O(N)

    方法三: 一个萝卜一个坑
    如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组
    遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止
     */
    public int findRepeatNumber(int[] nums) {
        //原地置换
        for (int i = 0; i < nums.length; ++i) {
            //说明不在应该在的地方
            while (nums[i] != i) {

                if (nums[i] < 0 || nums[i] > nums.length - 1) {
                    //说明输入不合法
                    throw new IllegalArgumentException();
                }
                if (nums[nums[i]] == nums[i]) {
                    //找到重复的元素
                    return nums[i];
                }
                //交换
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /*
        方法四:如果不能修改数组,则采用二分法 时间复杂度 O(N logN) + 空间复杂度 O(1)
        不能保证找出所有重复数字
        找出数组中在给定范围内的个数是否大于这个范围应有的个数,还是坑位法
        该方法不适用与这题,因为元素个数=n,只是题目保证了有重复的而已
        只适用与肯定多一个的地方
     */
    public int findRepeatNumber1(int[] nums) {
        int lo = 0,hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //找出nums在[lo,mid]中的元素数量
            int count = count(nums, lo, mid);
            //防止lo==hi不退出循环
            if (lo == hi) {
                if (count > 1) {
                    return lo;
                }
                else {
                    return -1;
                }
            }
            if (count > mid - lo + 1) {
                //说明重复元素在该区间里面(元素个数大于坑位)
                hi = mid;
            }
            else {
                //不能确定左边是否有重复元素,但右边肯定有重复的
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int count(int [] nums, int lo, int hi) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= lo && nums[i] <= hi) {
                result++;
            }
        }
        return result;
    }
}
