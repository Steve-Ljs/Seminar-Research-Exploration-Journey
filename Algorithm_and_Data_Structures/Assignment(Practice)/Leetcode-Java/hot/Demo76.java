package hot;

import java.util.HashMap;
import java.util.Map;

public class Demo76
{
    public String minWindow(String s, String t)
    {
        int lo=0,hi=0;//左右指针,指向最小覆盖子串的首尾
        int start=0,length=Integer.MAX_VALUE;//look 记录结果 求最小,length应该为最大
        int match = 0;//匹配情况

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();//代表滑动窗口
        for (char ch : t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(hi<s.length())
        {
            char chHi = s.charAt(hi);//look 命名为ch可能导致下面误导用ch表示S[lo]
            if(map.containsKey(chHi)) //如果出现了T中字符,则放入
            {
                window.put(chHi, window.getOrDefault(chHi, 0) + 1);
                if(map.get(chHi).equals(window.get(chHi))) ++match; //windows中该字符太多不会匹配多次
            }
            while(match==map.size())
            {
                if(length>hi-lo+1)
                {
                    length = hi - lo + 1;
                    start = lo;
                }
                char chLo = s.charAt(lo);
                if(map.containsKey(chLo)) //说明滑动了一个T中字符
                {
                    window.put(chLo,window.get(chLo)-1);
                    if(map.get(chLo)>window.get(chLo)) --match;
                }
                ++lo;//增加lo
            }

            ++hi;//扩大hi
        }
        //如果不包含这样的子串,那length没变
        if(length==Integer.MAX_VALUE) return "";
        return s.substring(start,start+length);
    }
}
