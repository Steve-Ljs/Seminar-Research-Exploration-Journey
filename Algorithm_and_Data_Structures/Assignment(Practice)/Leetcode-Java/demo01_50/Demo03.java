package demo01_50;


public class Demo03
{
    /*
    数组中记录了字符第一次出现的位置
     */
    public int lengthOfLongestSubstring(String s)
    {
        int result = 0;
        int[] index = new int[128];//ASCII 默认第一次出现位置为0
        for (int i = 0, lo = 0; i < s.length(); i++)
        {
            //保证不会倒退,如果出现了重复的字符,会读取上一个重复字符的下一个位置
            lo = Math.max(index[s.charAt(i)], lo);
            index[s.charAt(i)] = i + 1;//i位置的字符最近一次出现在i处,所以不包含该字符在i+1处
            result = Math.max(result, i - lo + 1);//lo为滑动窗口左端,i为右端
        }
        return result;
    }

    //滑动窗口
    public int lengthOfLongestSubstring1(String s)
    {
        int result = 0;
        int lo = 0;//无重复字符串的起始索引

        for (int i = 0; i < s.length(); i++)
        {
            int j = s.indexOf(s.charAt(i), lo);
            if (j == -1 || j >= i)//没有找到,或者不是在要查找的范围内
            {
                result = Math.max(result, i - lo + 1);
            } else
            {
                lo = j + 1;
            }
        }
        return result;
    }

}
