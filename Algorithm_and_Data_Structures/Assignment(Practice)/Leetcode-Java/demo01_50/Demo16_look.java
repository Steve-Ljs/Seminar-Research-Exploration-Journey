package demo01_50;


public class Demo16_look
{
    /*
    完美匹配肯定测得出来
    如果是不完美匹配,要么是左括号过多,要么是右括号过多
    如果是右括号过多,则在过多的那个地方,都给清0,就不会影响后续的判断了
    如果是左括号过多,则应在之后反向判断,转为右括号过多,就能正常判断了
     */
    public int longestValidParentheses(String s)
    {
        int result = 0;

        for (int i = 0, left = 0, right = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') ++left;
            else ++right;

            if (left == right) result = Math.max(result, 2 * left);
            else if (right > left)
            {
                left = 0;
                right = 0;
            }
        }
        //从后往前再来一遍,为了防止左括号过多导致的有些不计数()((())  或者(()
        for (int i = s.length() - 1, left = 0, right = 0; i >= 0; --i)
        {
            if (s.charAt(i) == '(') ++left;
            else ++right;

            if (left == right) result = Math.max(result, 2 * left);
            else if (right < left)//FBI warning 因为反过来了
            {
                left = 0;
                right = 0;
            }
        }
        return result;
    }
}
