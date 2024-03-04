package demo01_50;

import java.util.HashSet;
import java.util.Set;

public class Demo47_look
{
    /*
    因为只有当 currentNum 遇到了一个序列的开始， while 循环才会被执行
    （也就是 currentNum-1 不在数组 nums 里）， while 循环在整个运行过程中只会被迭代 n 次。
    所以总的时间复杂度是 O(n)的。
     */
    public int longestConsecutive(int[] nums)
    {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int num : set)
        {
            //从最小的那个算起,相当于计算一个个箭镞的长度,且从尾部算起
            if (!set.contains(num - 1))
            {
                int temp = 1;
                while (set.contains(num + 1))
                {
                    ++num;
                    ++temp;
                }
                //temp已经是箭簇的长度了,result为最长的那一根
                result = Math.max(result, temp);
            }
        }

        return result;
    }
}
