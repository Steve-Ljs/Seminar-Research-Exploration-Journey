package demo01_50;

public class Demo05
{
    /*
    中心扩展法,还是挺慢的
    单个与双个一起计算,直到停止,与右边组成双
     */
    public String longestPalindrome1(String s)
    {
        if (s.length() == 0) return "";
        String result;
        int begin = 0, end = 0;
        int lo, hi;
        for (int i = 0; i < s.length(); i++)
        {
            //单的变化
            lo = i;
            hi = i;
            while (lo - 1 >= 0 && hi + 1 < s.length() && s.charAt(lo - 1) == s.charAt(hi + 1))
            {
                --lo;
                ++hi;
            }
            //单的赋值
            if (hi - lo > end - begin)
            {
                begin = lo;
                end = hi;
            }
            //双的变化
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1))//两个不等直接没戏
            {
                lo = i;
                hi = i + 1;
                while (lo - 1 >= 0 && hi + 1 < s.length() && s.charAt(lo - 1) == s.charAt(hi + 1))
                {
                    --lo;
                    ++hi;
                }
                //双的赋值
                if (hi - lo > end - begin)
                {
                    begin = lo;
                    end = hi;
                }
            }
        }
        result = s.substring(begin, end + 1);//因为左开右闭
        return result;
    }
}
