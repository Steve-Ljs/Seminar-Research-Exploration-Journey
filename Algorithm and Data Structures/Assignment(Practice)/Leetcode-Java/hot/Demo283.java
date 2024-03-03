package hot;

public class Demo283 {
    public void moveZeroes(int[] nums) {
        //第一次遍历把元素往前压缩,把所有0都去掉,且用指针记录位置
        //第二次遍历把记录位置后的都置为0
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
