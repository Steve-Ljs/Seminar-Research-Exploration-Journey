package offer;

import java.util.HashMap;
import java.util.Map;

public class Demo48 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int lo = 0, hi = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hi = i;
            if (map.containsKey(ch)) {
                lo = Math.max(lo, map.get(ch) + 1);
            }
            map.put(ch, hi);
            max = Math.max(max, hi - lo + 1);
        }
        return max;
    }
}
