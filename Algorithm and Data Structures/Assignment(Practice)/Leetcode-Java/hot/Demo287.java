package hot;

public class Demo287 {
    public int findDuplicate(int[] nums) {
        //快慢指针法
        //把他看成一个链表的话,必然会是一个循环链表
        //快慢指针不断反复,必然会在循环里面的一段相遇
        int fast = nums[nums[0]], slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        //此时已经相遇在循环中,则要找出循环的起点,也就是重复的数字位置
        //推导一下可以得知从起点到循环点和从相遇到循环点路程一样
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
