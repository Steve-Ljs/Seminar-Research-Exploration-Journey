package demo51_100;

public class Demo99
{
    public int countSubstrings(String s)
    {
        int result = 0;
        for (int i = 0; i < s.length(); i++)
        {
            //以单个字符为中心扩展和以两个字符为中心的扩展
            result += check(s,i, i) + check(s,i, i + 1);
        }
        return result;
    }

    private int check(String s,int lo, int hi)
    {
        int temp = 0;
        while(lo>=0 && hi<s.length())
        {
            if(s.charAt(lo)==s.charAt(hi))
            {
                ++temp;
                --lo;
                ++hi;
            }
            else
            {
                break;
            }
        }
        return temp;
    }
}
