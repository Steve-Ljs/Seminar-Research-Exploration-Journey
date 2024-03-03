package niuke;

import java.util.LinkedHashMap;
import java.util.Map;

public class JZ54 {
    private Map<Character, Integer> map;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        map = new LinkedHashMap<>();
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return '#';
    }
}
