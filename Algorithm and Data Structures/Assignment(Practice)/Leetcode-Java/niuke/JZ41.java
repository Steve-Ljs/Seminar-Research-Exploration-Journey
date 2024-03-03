package niuke;

import java.util.ArrayList;

public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        //至少包括两个数,连续的正数序列
        int lo = 1, hi = 2, total = 3;
        temp.add(1);
        temp.add(2);
        //x + (x+1) <= sum
        while(lo <= (sum - 1) / 2) {
            if (total == sum) {
                result.add(new ArrayList<>(temp));

                //注意这里！，移动窗口，并且几个值都要变化，并且lo的顺序要注意
                temp.remove(0);
                total -= lo;
                lo++;
            }
            else if (total < sum) {
                hi++;
                temp.add(hi);
                total += hi;
            }
            else {
                //左窗口缩小,最多只能缩小到大小为2
                //但是没必要，因为sum根本不会达到这么小就已经退出了循环
                temp.remove(0);
                total-=lo;
                lo++;
            }
        }
        return result;
    }
}
