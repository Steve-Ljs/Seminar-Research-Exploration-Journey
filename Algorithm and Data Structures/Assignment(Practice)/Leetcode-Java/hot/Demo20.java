package hot;

import java.util.Stack;

public class Demo20
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
            {
                stack.push(ch);
            }
            else
            {
                //look 是匹配,不是相等
                //if(stack.isEmpty() || stack.pop()!=ch) return false;
                if (stack.isEmpty()) return false;

                char temp = stack.pop();
                switch (ch)
                {
                    case ')':
                        if (temp != '(') return false;
                        break;
                    case ']':
                        if (temp != '[') return false;
                        break;
                    case '}':
                        if (temp != '{') return false;
                        break;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        System.out.println('[' + 1);
        System.out.println(']' + 1);
    }
}
