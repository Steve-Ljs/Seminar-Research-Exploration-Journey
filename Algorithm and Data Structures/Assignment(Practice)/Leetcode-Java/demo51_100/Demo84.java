package demo51_100;

import java.util.Stack;

public class Demo84
{
    public String decodeString(String s)
    {
        StringBuilder result = new StringBuilder();
        int tempInt = 0;
        Stack<Integer> times = new Stack<>();
        Stack<String> repeats = new Stack<>();
        for (char ch : s.toCharArray())
        {
            if(ch==']')
            {
                StringBuilder temp = new StringBuilder();
                int time = times.pop();
                for (int i = 0; i < time; i++) temp.append(result);
                result = new StringBuilder(repeats.pop() + temp);
            }
            else if(ch=='[')
            {
                times.push(tempInt);
                repeats.push(result.toString());
                tempInt = 0;
                result = new StringBuilder();
            }
            else if(ch>='0' && ch<='9')
            {
                tempInt = 10 * tempInt + Integer.parseInt(ch+"");
            }
            else
            {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
