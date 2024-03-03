package hot;

import java.util.Deque;
import java.util.LinkedList;

public class Demo239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        //存储的是索引,而且存储的是降序的
        //从last开始添加,这样保证first都是最大的,而且后面索引都是大的
        Deque<Integer> deque = new LinkedList<>();
        //初始化
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; ++i) {
            if (deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }
}
