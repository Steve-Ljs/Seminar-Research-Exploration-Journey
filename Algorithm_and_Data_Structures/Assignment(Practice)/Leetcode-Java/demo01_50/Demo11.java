package demo01_50;

import java.util.Stack;

public class Demo11
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray())//就算输入其他字符,也忽略
        {
            if(ch=='(' || ch=='[' || ch=='{')
            {
                stack.push(ch);
            }
            else if(ch==')')
            {
                if(stack.isEmpty() || stack.pop()!='(') return false;
            }
            else if(ch==']')
            {
                if(stack.isEmpty() || stack.pop()!='[') return false;
            }
            else if(ch=='}')
            {
                if(stack.isEmpty() || stack.pop()!='{') return false;
            }
        }
        return stack.isEmpty();//FBI warning
    }
}
