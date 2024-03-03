package hot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo56
{
    public int[][] merge(int[][] intervals)
    {
        int N = intervals.length;
        List<int[]> result = new LinkedList<>();
        //按第一个元素排序
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        for (int i = 0; i < N; i++)
        {
            int lo=intervals[i][0];
            int hi=intervals[i][1];
            while(i+1<N && hi>=intervals[i+1][0])
            {
                ++i;//表明把下一个区间也纳入到了本区间里了
                hi=Math.max(hi,intervals[i][1]);//look 扩展该区间,选最大的一个
            }
            result.add(new int[]{lo, hi});
        }
        return (int[][]) result.toArray(new int [result.size()][2]);
    }

    public static void main(String[] args)
    {
        int[][] intervals = {{1, 3}, {8, 10}, {15, 18},{2, 6}};
        int[][] merge = new Demo56().merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
}
