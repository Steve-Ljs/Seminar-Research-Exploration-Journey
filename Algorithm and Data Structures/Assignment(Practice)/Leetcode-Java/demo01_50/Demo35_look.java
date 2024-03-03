package demo01_50;

import java.util.Stack;

public class Demo35_look
{
    /*
    一直维护一个递增序列,当不是递增时,可以把所有高的形成的矩形计算出来,并且移除他们,
    压入-1很有意义,例如,如果是7,5这种,i - 1 - stack.peek()就是1-1-(-1)=1,正好计算出7
    i - 1 - stack.peek()中,例如4785中,i=3,i-1=2,stack.peek()=1
    或者7,8移出去后,到了最后heights.length - 1=3,stack.peek()=0,开始计算的时候是不包含4的
    直到最后,stack.peek()=-1的时候,才计算4758长度为4的矩形
    由此可见,i - 1 - stack.peek(),计算的是第i-1个矩形和stack.peek()+1个矩形一起的面积
     */
    public int largestRectangleArea(int[] heights)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;

        for (int i = 0; i < heights.length; i++)
        {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i])
            {
                result = Math.max(result, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);//递增的就直接压入栈
        }
        while (stack.peek() != -1)
        {
            result = Math.max(result, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return result;
    }
}
