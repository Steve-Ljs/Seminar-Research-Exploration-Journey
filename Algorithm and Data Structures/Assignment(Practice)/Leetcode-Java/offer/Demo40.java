package offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo40 {

    //O(N),partition算法 需要修改数组
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0 || k > arr.length) return null;
        if (k == 0) return new int[0];
        //修改数组
        int lo = 0, hi = arr.length - 1;
        //计算的是下标,不会混乱
        k -= 1;
        while (lo <= hi) {
            int index = partition(arr, lo, hi);
            //比较的都是下标
            if (index < k) {
                lo = index + 1;
            }
            else if (index > k) {
                hi = index - 1;
            }
            else {
                return Arrays.copyOf(arr, index + 1);
            }
        }
        return arr;
    }


    private int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        int target = arr[lo];
        while (true) {
            while (++i <= hi && arr[i] < target) ;
            while (--j >= lo && arr[j] > target) ;
            if (i >= j) break;

            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[lo] = arr[j];
        arr[j] = target;
        return j;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k < 0 || k > arr.length) return new int[0];
        //默认是最小堆,但是需要最大堆,这样我们超过k个,就弹出最大的
        //实现大根堆需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<>((value1, value2) -> value2 - value1);
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.offer(arr[i]);
            }
            else if (!pq.isEmpty() && arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
