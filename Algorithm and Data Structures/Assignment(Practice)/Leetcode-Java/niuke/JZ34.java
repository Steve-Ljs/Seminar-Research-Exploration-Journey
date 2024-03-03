package niuke;

import java.util.HashMap;

public class JZ34 {
    public int FirstNotRepeatingChar(String str) {
        //true代表有重复
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), true);
            } else {
                map.put(str.charAt(i), false);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (!map.get(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
