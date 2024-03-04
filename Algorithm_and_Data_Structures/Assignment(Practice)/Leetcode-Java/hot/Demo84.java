package hot;

import java.util.Stack;

public class Demo84
{
    public int largestRectangleArea(int[] heights)
    {
        //递增序列 存储的是索引下标
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int n = heights.length;
        //防止最左边元素计算不了面积
        stack.push(-1);
        for (int i = 0; i < n; i++)
        {
            //heights[stack.top()]=heights[i]的要留下,因为前面的元素还可以继续扩展
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i])
            {
                //这里计算的是以弹出那个元素为高度的最大矩形
                int index = stack.pop();
                //look 这里也要按照下面的思路,即该元素的左边界是stack.top()+1 而不能仅仅是(i - index) * heights[index]
                result = Math.max(result, (i - stack.peek() - 1) * heights[index]);
            }
            //此时为递增序列
            stack.push(i);
        }
        //对递增序列进行计算
        //这些元素每一个都可以扩展到数组尽头
        while (stack.peek() != -1)
        {
            //范围是[ stack.top()+1 , N-1 ]
            int index = stack.pop();
            result = Math.max(result, (n - stack.peek() - 1) * heights[index]);
        }
        return result;
    }
}
