package demo51_100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Demo86
{
    public int[][] reconstructQueue(int[][] people)
    {
        //让他们先按身高降序,如果身高相等,再按排名升序
        Arrays.sort(people, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] p1, int[] p2)
            {
                return p1[0]==p2[0] ? p1[1]-p2[1]:p2[0]-p1[0];
            }
        });

        //上面排序后的结果:[7,0],[7,1],[6,1],[5.0],[5.2],[4.4]
        List<int[]> result = new LinkedList<>();
        for (int[] p : people)
        {
            /*
            add(int index,E element)在此列表中指定的位置插入指定的元素。移动当前在该位置处的元素,所有后续元素都向右移。
            因为是大的先放,所以大的只要关注自己的排名,放到小的时候,因为大的看不见小的,所以小的放入不会影响大的排名
            而且小的放的时候,里面都是>=它的,所以只要根据自己的排名直接放入相应的位置即可
             */
            result.add(p[1], p);
        }
        //上面的result已经存储了结果了,只要将他转为数组即可
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args)
    {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        new Demo86().reconstructQueue(people);
    }
}
