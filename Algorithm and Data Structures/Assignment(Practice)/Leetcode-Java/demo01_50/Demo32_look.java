package demo01_50;

import java.util.HashMap;
import java.util.Map;

public class Demo32_look
{
    /*
    滑动窗口的思路
     */
    public String minWindow(String s, String t)
    {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int lo = 0, hi = 0;
        int start = 0, length = Integer.MAX_VALUE;
        int match = 0;//匹配情况

        while (hi < s.length())
        {
            char ch = s.charAt(hi);
            if (map.containsKey(ch))
            {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (map.get(ch).equals(window.get(ch))) ++match;
                //只在等于的这一刻加了一次,后面如果还是这个字符,不加了
            }
            while (match == map.size())
            {
                if (hi - lo + 1 < length)
                {
                    length = hi - lo + 1;
                    start = lo;
                }
                char ch1 = s.charAt(lo);
                if (map.containsKey(ch1))
                {
                    window.put(ch1, window.get(ch1) - 1);
                    if (map.get(ch1) > window.get(ch1)) --match;
                    //因为可能本来就有重复的字符,减去了仍然够,所以需要判断
                }
                ++lo;//FBI warning 应该放在最后,因为首先要删除那个元素,再继续到下一个
            }
            ++hi;
        }
        if (length == Integer.MAX_VALUE) return "";
        else return s.substring(start, start + length);
    }

    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        new Demo32_look().minWindow(s, p);
    }
}
