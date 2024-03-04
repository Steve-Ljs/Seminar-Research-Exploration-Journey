package offer;

import java.util.HashSet;
import java.util.Set;

public class Demo61 {
    /*
   有重复不算对子,用set判断即可
   大小王没有影响,就忽略他
   剩下的数,初始化 max = 0, min = 14, 确保他们能指向正确的max,min
   如果无大小王则max - min = 4
   有一张则为则max - min = 3
   有两张则max - min = 2
   ...
   如果全是大小王则max - min = -14,仍然满足

   */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;//确保他们能指向正确的max,min
        for (int num : nums) {
            if (num == 0) continue; //跳过大小王
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) return false; //有重复,当然不算顺子
            repeat.add(num);
        }
        return max - min < 5;
    }
}
