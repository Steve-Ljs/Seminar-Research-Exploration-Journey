package offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo50 {
    //超级精简版
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, !map.containsKey(ch));
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch)) return ch;
        }
        return ' ';
    }


    //LinkedHashMap
    public char firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return ' ';
    }
}
