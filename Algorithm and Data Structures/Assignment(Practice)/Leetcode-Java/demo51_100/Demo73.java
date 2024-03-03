package demo51_100;

public class Demo73 {
    //实际上相当于把非0的放入一个LinkedList里面,后面补充0,只是这里把当前数组当作了list,后面再改为0,秒啊!!!!!!
    //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
    //非0元素统计完了，剩下的都是0了,所以第二次遍历把末尾的元素都赋为0即可
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) if (nums[i] != 0) nums[j++] = nums[i];
        for (int i = j; i < nums.length; ++i) nums[i] = 0;
    }


    //类似冒泡的算法,太慢了
    public void moveZeroes1(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] == 0) {
                for (int j = lo; j < hi; j++) nums[j] = nums[j + 1];
                nums[hi--] = 0;
            }
            else {
                ++lo;
            }
        }
    }
}
