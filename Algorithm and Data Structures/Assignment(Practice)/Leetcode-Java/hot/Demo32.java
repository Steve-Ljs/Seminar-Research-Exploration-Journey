package hot;


import java.util.Stack;

public class Demo32
{

    //在栈底放最后一个没有被匹配的右括号的下标
    public int longestValidParentheses1(String s)
    {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//默认的栈底,这样计算会正确
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                //说明弹栈把最后一个没有被匹配的右括号的下标弹出去的,就说明该)也是没有(匹配的
                if (stack.isEmpty()) stack.push(i);
                else result = Math.max(result, i - stack.peek());
            }
        }
        return result;
    }


    /*
    完美匹配肯定测得出来
    如果是不完美匹配,要么是左括号过多,要么是右括号过多
    如果是右括号过多,则在过多的那个地方,都给清0,就不会影响后续的判断了
    如果是左括号过多,则应在之后反向判断,转为右括号过多,就能正常判断了
 */
    public int longestValidParentheses(String s)
    {
        int result = 0, left = 0, right = 0;
        //第一轮匹配的是右括号多的情况 即类似())(()))这些
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == '(') ++left;
            else ++right;
            if (left == right)
            {
                result = Math.max(result, 2 * left);
            }
            else if (right > left)
            {
                left = 0;
                right = 0;
            }
        }
        //反向遍历 判断左括号过多的情况
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            char ch = s.charAt(i);
            if (ch == '(') ++left;
            else ++right;
            if (left == right)
            {
                result = Math.max(result, 2 * left);
            }
            else if (right < left) //这里要改变
            {
                left = 0;
                right = 0;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
    }
}
