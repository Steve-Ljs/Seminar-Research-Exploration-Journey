package demo01_50;

import java.util.*;

public class Demo26_look
{
    /*
    1.先按区间的第一个元素排序
    2.如果i+1首元素大于i尾元素,添加i,进入下一个;否则,合并两个,尾元素为两个较大的一个,且继续判断
     */
    public int[][] merge(int[][] intervals)
    {
        //FBI warning 如果为空,不应该返回null,所以返回intervals是最好的
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] nums1, int[] nums2)
            {
                return nums1[0] - nums2[0];
            }
        });

        List<int []> result = new LinkedList<>();//FBI warning 只有这样才能转换
        int[] temp = intervals[0];

        for (int i = 1; i < intervals.length; ++i)
        {
            if(intervals[i][0]>temp[1])
            {
                result.add(temp);//安全的原因是temp是指向原数组的,之后试试改变指向,不是改变值
                temp = intervals[i];//注意引用的指向
            }
            else
            {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }
        }
        result.add(temp);//不用判断,必然有个可以加入的

        return (int[][]) result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args)
    {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new Demo26_look().merge(intervals);
    }
}
