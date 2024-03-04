package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Demo59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];

        int[] res = new int[n - k + 1];
        //存储索引,而且索引对应的元素值降序
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            //把前面小于他的去掉
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.getFirst()];
        for (int i = k; i < n; i++) {
            if (deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            res[i - k + 1] = nums[deque.getFirst()];
        }

        return res;
    }
}
