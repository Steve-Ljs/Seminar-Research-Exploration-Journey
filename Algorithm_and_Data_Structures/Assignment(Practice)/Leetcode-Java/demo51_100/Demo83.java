package demo51_100;

import java.util.*;

public class Demo83
{
    public List<Integer> topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        //用优先级队列完美的解决了想对value排序的问题 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for (Integer integer : map.keySet())
        {
            heap.add(integer);
            if(heap.size()>k) heap.poll();
        }
        //最小堆弹出数值最小的元素,所以需要反转,得到前k大的
        List<Integer> result=new LinkedList<>();
        while(!heap.isEmpty()) result.add(heap.poll());
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1,1, 1, 2, 2, 3,4,4};
        List<Integer> list = new Demo83().topKFrequent(nums, 2);
    }
}
