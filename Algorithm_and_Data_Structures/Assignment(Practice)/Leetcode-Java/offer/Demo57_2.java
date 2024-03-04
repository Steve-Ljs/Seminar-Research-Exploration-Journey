package offer;

import java.util.LinkedList;
import java.util.List;

public class Demo57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new LinkedList<>();
        //因为至少包含两个数 其实是滑动窗口
        int lo = 1, hi = 2;
        //只要扩展lo就好,因为hi到target会自动停止增长
        while (lo < hi) {
            int sum = (lo + hi) * (hi - lo + 1) / 2;
            if (sum == target) {
                int[] temp = new int[hi - lo + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = lo + i;
                }
                res.add(temp);
                lo++;
            }
            else if (sum < target) {
                hi++;
            }
            else {
                lo++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
