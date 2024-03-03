package demo51_100;

import java.util.*;

public class Demo100
{
    public static void main(String[] args)
    {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new Demo100().dailyTemperatures(T);
        System.out.println(Arrays.toString(result));
    }
    public int[] dailyTemperatures(int[] T)
    {
        //从右向左看,始终保持一个单调递减的栈
        int[] result = new int[T.length];
        //只存储索引
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length-1; i >= 0; --i)
        {
            //把栈中比i索引对应的值还小的元素剔除,因为前方有大的,肯定轮不到后面更小的那个
            //等于的也需要剔除,相等的不剔除,计算就是1,即温度相等的也算了,不符合题意
            while(!stack.empty() && T[stack.peek()]<= T[i])
            {
                stack.pop();
            }
            result[i] = stack.empty()? 0:stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
