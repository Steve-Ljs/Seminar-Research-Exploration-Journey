package demo51_100;

import java.util.Deque;
import java.util.LinkedList;

public class Demo69_look
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if(nums==null || nums.length==0 || k<=0 || k>nums.length) throw new RuntimeException();

        int[] result = new int[nums.length - k + 1];

        //双向队列,存储索引 存储窗口内的降序 从last开始添加,这样保证了first都是最大的,且后面的索引都是大的
        Deque<Integer> deque = new LinkedList<>();
        //初始化
        for (int i = 0; i < k; i++)
        {
            while(!deque.isEmpty() && nums[deque.getLast()]<=nums[i]) deque.removeLast();
            deque.addLast(i);
        }
        result[0]=nums[deque.getFirst()];//记住之前存的只是索引啊

        for (int i = k; i < nums.length; i++)
        {
            if(deque.getFirst()<i-k+1) deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.getLast()]<=nums[i]) deque.removeLast();
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }
}
