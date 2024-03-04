package demo51_100;

import java.util.*;

public class Demo98
{
    public static void main(String[] args)
    {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A','B', 'C', 'D','E', 'F', 'G'};
        int i = new Demo98().leastInterval(tasks, 2);
        System.out.println(i);
    }
    //巧妙解法
    /*
    假设最大的有p个,间隔为n,那么p个竖着放,且最少使用时间是(p-1)*(n+1)+1
    而此时的空闲位置(p-1)*n可以用来安排剩余的
     */
    public int leastInterval(char[] tasks, int n)
    {
        int[] contains = new int[26];
        for (char task : tasks)
        {
            ++contains[task - 'A'];
        }
        Arrays.sort(contains);
        int p = contains[25];

        int space = (p - 1) * n;//此时的空闲位置
        int result = (p - 1) * (n + 1) + 1;//先等于最少使用时间
        for(int i=24;i>=0 && contains[i]>0;--i)
        {
            if(contains[i]==p)//只有两种情况,要么小于最大,要么等于最大
            {
                space -= (p - 1);
                ++result;//占用了那个单独的第p行
            }
            else
            {
                space -= contains[i];
            }
        }
        //space<0就说明空余位置不够了,需要新开虚拟的一列,存储多余的比较少的,但是研究发现这样总的时间数就是元素个数
        //result此时为正常的格子数,-space是新开的虚拟列中元素的个数
        return space<0?result-space:result;
    }
    //使用优先级队列
    public int leastInterval1(char[] tasks, int n)
    {
        int[] contains = new int[26];
        for (char task : tasks)
        {
            ++contains[task - 'A'];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int contain : contains)
        {
            if(contain!=0) queue.add(contain);
        }

        int result = 0;
        while(!queue.isEmpty())//为空说明了全部任务结束
        {
            //这个循环里面是一个n周期
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++)
            {
                if(!queue.isEmpty())//为空说明所有任务都搞了一遍,如果i还不为n,就要空转了
                {
                    //执行一次任务,并且不要执行完的任务
                    int x = queue.poll() - 1;
                    if(x!=0) temp.add(x);
                }
                ++result;//空转的也计算在内了
                if(temp.isEmpty()&&queue.isEmpty())
                {
                    //任务结束
                    return result;
                }
            }
            for (Integer integer : temp)
            {
                queue.add(integer);
            }
            //把执行一次过后的放入,接着执行
        }
        return result;
    }
}
