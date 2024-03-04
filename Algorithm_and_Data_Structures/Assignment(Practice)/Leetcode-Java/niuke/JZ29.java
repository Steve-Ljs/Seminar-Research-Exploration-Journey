package niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k < 0 || k > input.length) return result;
        if (k == 0) return result;

        Queue<Integer> maxPQ = new PriorityQueue<>((num1, num2)->num2 - num1);
        for (int i = 0; i < input.length; i++) {
            if (maxPQ.size() < k) {
                maxPQ.offer(input[i]);
            }
            else if (input[i] < maxPQ.peek()){
                maxPQ.poll();
                maxPQ.offer(input[i]);
            }

        }
        for (int i = 0; i < k; i++) {
            result.add(maxPQ.poll());
        }
        return result;
    }
}
