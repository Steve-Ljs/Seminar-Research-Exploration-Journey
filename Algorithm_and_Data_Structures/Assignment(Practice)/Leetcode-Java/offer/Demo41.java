package offer;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo41 {
    private Queue<Integer> pqMin, pqMax;
    /** initialize your data structure here. */
    public Demo41() {
        pqMin = new PriorityQueue<>();//最小堆,保存较大的一部分元素
        pqMax = new PriorityQueue<>((x,y)-> y - x);//最大堆,保存较小的一部分元素
    }

    public void addNum(int num) {
        //插入为奇数
        if (pqMin.size() != pqMax.size()) {
            pqMin.add(num);
            pqMax.add(pqMin.poll());
        }
        else {
            pqMax.add(num);
            pqMin.add(pqMax.poll());
        }
    }

    public double findMedian() {
        //size相同则总数为偶数,
        return pqMin.size() != pqMax.size() ?pqMin.peek():(pqMin.peek() + pqMax.peek()) / 2.0;

    }
}
