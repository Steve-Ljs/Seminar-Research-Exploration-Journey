package hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo03
{
    public int lengthOfLongestSubstring1(String s)
    {
        int maxLength = 0, lo = 0, hi = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            hi = i;
            if(map.containsKey(ch)) lo = Math.max(lo,map.get(ch)+1);//look
            map.put(ch, hi);//look
            maxLength = Math.max(maxLength, hi - lo + 1);
        }
        return maxLength;
    }
    //数组中记录了字符第一次出现的位置
    public int lengthOfLongestSubstring(String s)
    {
        int result = 0,lo=0;
        int[] map = new int[128];
        Arrays.fill(map, -1);//初始化为-1
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            //保证不会倒退,如果出现了重复的字符,会读取上一个重复字符的下一个位置
            lo = Math.max(lo, map[ch]+1);
            map[ch] = i;
            result = Math.max(result, map[ch] - lo + 1);//lo为滑动窗口左端,i为右端
        }
        return result;
    }

    public static void main(String[] args)
    {
        new Demo03().lengthOfLongestSubstring("ABC");
    }
}
