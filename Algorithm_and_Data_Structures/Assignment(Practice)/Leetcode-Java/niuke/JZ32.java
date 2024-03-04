package niuke;

import java.util.Arrays;

public class JZ32 {
    /*
    定义比较规则：[xy]<[yx],则让x<y
    这样将数组排序后拼接即可
    */
    public String PrintMinNumber(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, (string1, string2) -> (string1 + string2).compareTo(string2 + string1));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
        }
        return result.toString();
    }
}
